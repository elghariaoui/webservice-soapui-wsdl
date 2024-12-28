package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

//library JAXWS
@WebService(serviceName = "BanqueWS" )
public class BanqueService {

    @WebMethod(operationName = "conversionEuroToDhs")
    public double conversion(@WebParam(name = "montant") double mt) {
        return mt * 11;
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int code) {
        return new Compte(code, Math.random()*6000, new Date());

    }
    @WebMethod
    public List<Compte> getComptes() {
        return List.of(
                new Compte(1, Math.random()*5000, new Date()),
                new Compte(2, Math.random()*8000, new Date()),
                new Compte(3, Math.random()*7000, new Date())
        );
    }

}
