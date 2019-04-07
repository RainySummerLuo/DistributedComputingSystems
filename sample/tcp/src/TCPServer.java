import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] ar) {
        try {
            ServerSocket ss = null;
            System.out.println("Sever Ready...");
            while (true) {
                Socket s = ss.accept();
                System.out.println("s = " + s);
                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr, 512);
                String data = br.readLine();
                System.out.println("msg = " + data);
                OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
                BufferedWriter bw = new BufferedWriter(osw, 512);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("Message OK!");
                pw.flush();
            }
        } catch (IOException ignored) {}
    }
}