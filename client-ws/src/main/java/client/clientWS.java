package client;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;
import java.util.Scanner;

public class clientWS {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println("Stub proxy lancé");
        //conversion solde euro to dhs
        System.out.println("----------------------------");
        System.out.println("--Conversion euros aux DHS--");
        System.out.println("----------------------------");

        System.out.println("Entrez le montant en euros : ");
        Scanner sc = new Scanner(System.in);
        double montant = sc.nextDouble();
        System.out.format("La conversion en dhs de %,.3f euros vaut %,.3f dhs \n", montant, proxy.conversionEuroToDhs(montant));

        //getCompte
        System.out.println("---------------------------------------------");
        System.out.println("--Récupération des informations d'un compte--");
        System.out.println("---------------------------------------------");
        System.out.println("Entrez un numéro de compte : ");
        Compte compte = proxy.getCompte(sc.nextInt());
        System.out.println("Code du compte : "+compte.getCode());
        System.out.println("Solde du compte : "+String.format("%,.3f",compte.getSolde()));
        System.out.println("Date de création du compte : "+compte.getDateCreation());
        sc.close();
        //affichage des comptes
        System.out.println("----------------------------------");
        System.out.println("--Affichage de tous les comptes --");
        System.out.println("----------------------------------");

        List<Compte> comptes = proxy.getComptes();
        for (Compte c : comptes) {
            System.out.println("code du compte " + c.getCode());
            System.out.println("solde du compte " + String.format("%,.3f", c.getSolde()));
            System.out.println("Date de création du compte " + c.getDateCreation());
            System.out.println("-----");
        }

    }
}
