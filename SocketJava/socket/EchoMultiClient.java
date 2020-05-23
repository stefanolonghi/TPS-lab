// EchoMultiClient.java
// Client che testa l'EchoMultiServer lanciando più clienti.
import java.net.*;
import java.io.*;
class ClientThread extends Thread {
 private Socket socket;
 private BufferedReader in;
 private PrintWriter out;
 private static int counter = 0;
 private int id = counter++;
 private static int threadcount = 0;
 public static int threadCount() {
 return threadcount;
 }
 public ClientThread(InetAddress addr) {
 threadcount++;
 try {
 socket = new Socket(addr, EchoMultiServer.PORT);
 System.out.println("EchoClient n° "+id+": started");
 System.out.println("Client Socket: "+ socket);
 } catch(IOException e) {}
 // Se la creazione della socket fallisce non è necessario fare nulla
 try {
 InputStreamReader isr = new InputStreamReader(socket.getInputStream());
 in = new BufferedReader(isr);
 OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
 out = new PrintWriter(new BufferedWriter(osw), true);
 start();
 } catch(IOException e1) {
 // in seguito ad ogni fallimento la socket deve essere chiusa, altrimenti
 // verrà chiusa dal metodo run() del thread
 try {
 socket.close();
 } catch(IOException e2) {}
 }
 }
 public void run() {
 try {
 for(int i =0;i <10; i++) {
 out.println("client "+id +" msg "+i);
 System.out.println("Msg sent: client "+id+" msg"+i);
 String str = in.readLine();
 System.out.println("Echo: "+str);
 }
 out.println("END");
 } catch(IOException e) {}
 try {
 System.out.println("Client "+id+" closing...");
socket.close();
 } catch(IOException e) {}
 threadcount--;
 }
} // ClientThread
public class EchoMultiClient {
 static final int MAX_THREADS = 10;
 public static void main(String[] args) throws IOException,InterruptedException {
 InetAddress addr;
 if (args.length == 0) addr = InetAddress.getByName(null);
 else addr = InetAddress.getByName(args[0]);
 while(true) {
 if (ClientThread.threadCount() < MAX_THREADS)
 new ClientThread(addr);
 Thread.currentThread().sleep(1000);
 }
 }
} // EchoMultiClient