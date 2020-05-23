// EchoMultiServer.java
import java.io.*;
import java.net.*;
class ServerThread extends Thread {
 private static int counter = 0;
 private int id = ++counter;
 private Socket socket;
 private BufferedReader in;
 private PrintWriter out;
 public ServerThread(Socket s) throws IOException {
 socket = s;
 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
 out = new PrintWriter(new BufferedWriter(osw), true);
 start();
 System.out.println("ServerThread "+id+": started");
 }
public void run() {
 try {
 while (true) {
 String str = in.readLine();
 if (str.equals("END")) break;
 System.out.println("ServerThread "+id+": echoing -> " + str);
 out.println(str);
 }
 System.out.println("ServerThread "+id+": closing...");
 } catch (IOException e) {}
 try {
 socket.close();
 } catch(IOException e) {}
 }
} // ServerThread
public class EchoMultiServer {
 static final int PORT = 1050;
 public static void main(String[] args) throws IOException {
 ServerSocket serverSocket = new ServerSocket(PORT);
 System.out.println("EchoMultiServer: started");
 System.out.println("Server Socket: " + serverSocket);
 try {
 while(true) {
 // bloccante finchè non avviene una connessione:
 Socket clientSocket = serverSocket.accept();
 System.out.println("Connection accepted: "+ clientSocket);
 try {
 new ServerThread(clientSocket);
 } catch(IOException e) {
 clientSocket.close();
 }
 }
 }
 catch (IOException e) {
 System.err.println("Accept failed");
 System.exit(1);
 }
 System.out.println("EchoMultiServer: closing...");
 serverSocket.close();
 }
} // EchoMultiServer