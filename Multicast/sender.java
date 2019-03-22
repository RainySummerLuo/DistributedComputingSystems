package mul;

import java.net.*;

public class sender {
	public static void main(String[] args) {
		InetAddress ia = InetAddress.getByName("235.123.44.55");
		MulticastSocket so = new MulticastSocket(10000);
		so.joinGroup(ia);
		byte[] buf = new byte[6255];
		DatagramPacket rec = new DatagramPacket(buf, buf.length);
		so.receive(rec);
		String msg = new String(rec.getData()).trim();
        System.out.println("msg: " + msg);
        so.leaveGroup(ia);
        so.close();
	}
}
