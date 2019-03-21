import java.net.*;

public class EchoUDPServer {
 public static void main(String[] args) {
  DatagramSocket server = null;
  DatagramPacket receivePacket, sendPacket;
  try {
   server = new DatagramSocket(7777);
   System.out.println("Server Ready...");
   byte [] buffer = new byte[6255];
   while(true){
    receivePacket = 
      new DatagramPacket(buffer, buffer.length);
      server.receive(receivePacket); // String will be stored in buffer of receivPacket
       String msg = new String(buffer, 0, receivePacket.getLength());
    if(msg.equals("bye")) break;
    System.out.println("Message from Client : " + msg);
    sendPacket = 
      new DatagramPacket(msg.getBytes(), 
               msg.getBytes().length,
               receivePacket.getAddress(),
               receivePacket.getPort());
    server.send(sendPacket);
   }
  } catch (Exception e) {
   System.out.println(e.getMessage());
  }
 }
}

 