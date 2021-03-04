package clientbase;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientBase {

    public static void main(String[] args) {
        System.out.println("Apertua connessione");
        try {
            Socket server = new Socket("127.0.0.1", 5500);
            
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            Scanner tastiera = new Scanner(System.in);
            int n;
            
            System.out.print("Inserire un numero: ");
            n = tastiera.nextInt();
            out.println(n);
            
            server.close();
            System.out.println("chiusura connessione");
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}