package servidor;

import interfaz.BolsaEmpleo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.UUID;

public class BolsaEmpleoImpl extends UnicastRemoteObject implements BolsaEmpleo {
    private static final String RUTA_OFERTAS = "data/ofertas.txt";
    private static final String RUTA_INSCRIPCIONES = "data/inscripciones.txt";

    public BolsaEmpleoImpl() throws RemoteException {
        super();
    }

    public String registrarOferta(String empresa, String puesto, String salario, String descripcion) throws RemoteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_OFERTAS, true))) {
            String codigo = UUID.randomUUID().toString();
            writer.write(codigo + ";" + empresa + ";" + puesto + ";" + salario + ";" + descripcion);
            writer.newLine();
            return "Satisfactoria - Código de la oferta: " + codigo;
        } catch (IOException e) {
            e.printStackTrace();
            return "No satisfactoria";
        }
    }

    public String consultarOfertas() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_OFERTAS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String inscribirseAOferta(String aspirante, String codigoOferta) throws RemoteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_INSCRIPCIONES, true))) {
            writer.write(codigoOferta + ";" + aspirante);
            writer.newLine();
            return "Inscripción exitosa";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al inscribirse";
        }
    }
}
