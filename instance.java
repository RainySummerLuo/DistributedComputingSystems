package mul;

import java.io.IOException;
import java.net.*;

public class instance {
	public static void main(String[] args) {
		InetAddress ia = InetAddress.getByName("235.123.44.55");
		MulticastSocket so = new MulticastSocket(10000);
		so.joinGroup(ia);
		byte[] buf = new byte[6255];
		DatagramPacket rec = new DatagramPacket(buf, buf.length);
		so.receive(rec);
		so.leaveGroup(ia);
		so.close();
		String msg = new String(rec.getData()).trim();
		System.out.println("msg: " + msg);
	}
}
