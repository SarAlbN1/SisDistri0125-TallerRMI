package cliente;

import interfaz.BolsaEmpleo;
import java.rmi.Naming;
import java.util.Scanner;

public class ClienteAspirante {
    public static void main(String[] args) {
        try {
            BolsaEmpleo stub = (BolsaEmpleo) Naming.lookup("rmi://localhost/BolsaEmpleo");
            System.out.println("Ofertas disponibles:\n");
            System.out.println(stub.consultarOfertas());

            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el código de la oferta a la que desea inscribirse: ");
            String codigo = sc.nextLine();

            String inscripcion = stub.inscribirseAOferta(nombre, codigo);
            System.out.println(inscripcion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
