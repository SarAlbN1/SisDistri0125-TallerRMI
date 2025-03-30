package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BolsaEmpleo extends Remote {
    String registrarOferta(String empresa, String puesto, String salario, String descripcion) throws RemoteException;
    String consultarOfertas() throws RemoteException;
    String inscribirseAOferta(String aspirante, String codigoOferta) throws RemoteException;
}
