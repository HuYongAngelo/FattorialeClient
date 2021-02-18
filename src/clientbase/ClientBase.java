package clientbase;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientBase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        
        while (true) {
            System.out.print("Inserire una parola: ");
            a = sc.next();
            
            System.out.println("Apertua connessione");
            try {
                Socket server = new Socket("127.0.0.1", 5500);
                OutputStream alServer = server.getOutputStream();
                BufferedWriter scrittore = new BufferedWriter(new OutputStreamWriter(alServer));
                
                scrittore.write(a);
                
                InputStream dalServer = server.getInputStream();
                BufferedReader lettore = new BufferedReader(new InputStreamReader(dalServer));

                String risposta = lettore.readLine();
                System.out.println("risposta del server: " + risposta);
                
                
                scrittore.close();
                lettore.close();
                server.close();
                System.out.println("chiusura connessione");
                Thread.sleep(5000);
            } catch (IOException ex) {
                Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
