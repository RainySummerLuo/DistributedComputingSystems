import java.util.*;
import java.rmi.*;
import java.net.*;

public class timeClient {
	public static void main(String args[]) {
		if (args.length == 0 || !args[0].startsWith("rmi:")) {
			System.err.println("Usage: ...");
			return;
		}
		long lt = 0;
		try {
			Object o = Naming.lookup(args[0]);
			timeServer ts = (timeServer) o;
			lt = ts.getTime();
		} catch (MalformedURLException ex) {
			System.err.println(args[0] + " is not a valid RMI UrL");
		} catch (RemoteException ex) {
			System.err.println(args[0] + " from remote object");
		} catch (NotBoundException ex) {
			System.err.println("cannot find remote object");
		}
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		Date serverDate = new Date(lt);
		System.out.println(lt);
		System.out.println(serverDate);
	}
}
