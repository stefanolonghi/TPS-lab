// EchoServer.java
import java.io.*;
import java.net.*;
public class EchoServer {
public static final int PORT = 1050; // porta al di fuori del range 1-1024 !
public static void main(String[] args) throws IOException {
 ServerSocket serverSocket = new ServerSocket(PORT);
 System.out.println("EchoServer: started ");
 System.out.println("Server Socket: " + serverSocket);
 Socket clientSocket=null;
 BufferedReader in=null;
 PrintWriter out=null;
 try {
 // bloccante finchè non avviene una connessione
 clientSocket = serverSocket.accept(); 
 //accept restituise ip e porta del client e puntatori che permettono di
 //accedere al testo del messaggio.
 System.out.println("Connection accepted: "+ clientSocket);
 // creazione stream di input da clientSocket
 InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
 //getinsputstream prende il messaggio contenuto nel messaggio del client
 in = new BufferedReader(isr);
 // creazione stream di output su clientSocket
 OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
 BufferedWriter bw = new BufferedWriter(osw);
 out = new PrintWriter(bw, true);
 //ciclo di ricezione dal client e invio di risposta
 while (true) {
 String str = in.readLine();
 if (str.equals("END")) break;
 System.out.println("Echoing: " + str);
 out.println(str); 
 //out punta al buffer di uscita, quindi viene mandato in uscita sulla
 //scheda di rete
 }
 }
 catch (IOException e) {
 System.err.println("Accept failed");
 System.exit(1);
 }
 // chiusura di stream e socket
 System.out.println("EchoServer: closing...");
 out.close();
 in.close();
 clientSocket.close();
 serverSocket.close();
 }
} // EchoServer