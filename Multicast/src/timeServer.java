import java.rmi.Remote;
import java.rmi.RemoteException;

public interface timeServer extends Remote {
	long getTime() throws RemoteException;
}