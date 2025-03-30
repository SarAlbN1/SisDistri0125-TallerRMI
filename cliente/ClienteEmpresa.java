package cliente;

import interfaz.BolsaEmpleo;
import java.rmi.Naming;

public class ClienteEmpresa {
    public static void main(String[] args) {
        try {
            BolsaEmpleo stub = (BolsaEmpleo) Naming.lookup("rmi://localhost/BolsaEmpleo");
            String respuesta = stub.registrarOferta("EmpresaXYZ", "Desarrollador", "3000000", "Con experiencia en Java");
            System.out.println(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
