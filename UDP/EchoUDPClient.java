import java.io.*;
import java.net.*;
import java.util.*;

public class EchoUDPClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = null;
        try{
            DatagramSocket soc = new DatagramSocket();
            while((line = sc.nextLine()) != null){
                DatagramPacket dp = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("localhost"), 7777);
                soc.send(dp);
                if(line.equals("bye")) break;
                byte[] buffer = new byte[6255];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                soc.receive(receivePacket);
                String msg = new String(buffer, 0, receivePacket.getLength());
                System.out.println("Server says : " + msg);
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}