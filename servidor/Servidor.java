package servidor;

import interfaz.BolsaEmpleo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            BolsaEmpleo obj = new BolsaEmpleoImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/BolsaEmpleo", obj);
            System.out.println("Servidor RMI BolsaEmpleo iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
