import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class timeServerImpl extends UnicastRemoteObject implements timeServer {
	public timeServerImpl ( ) throws RemoteException {
		super( );
	}

	public long getTime() throws RemoteException {
		return    System.currentTimeMillis(); //using java.util.Date class
	}					//but need to convert it to long

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			timeServerImpl f = new timeServerImpl( );
			Naming.rebind("myTimeServer", f);
			System.out.println("myTimeServer ready.");
		} catch (RemoteException rex) {
			System.out.println("Exception in timeServerImpl.main: " + rex);
		} catch (MalformedURLException ex) {
			System.out.println("MalformedURLException " + ex);
		}
	}
}