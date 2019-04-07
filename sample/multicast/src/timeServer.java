import java.rmi.*;
import java.util.Date;
public interface timeServer extends Remote {
public  long  getTime() throws RemoteException;
}