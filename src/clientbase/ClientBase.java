package clientbase;

import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientBase {

    public static void main(String[] args) {
        String[] a;
        
        System.out.println("Apertua connessione");
        try {
            Socket server = new Socket("127.0.0.1", 5500);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            String s = "";
            
            while (!s.equals("exit")) {
                System.out.println("Inserire frase da inviare al server:");
                s = tastiera.nextLine();
                System.out.println("frase inserita: " + s);
                out.println(s);
                String risposta = in.readLine();
                System.out.println("risposta del server: " + risposta);
                a = risposta.split(" ");
                System.out.println("Hai inserito "+a[a.length-1]);
            }
            
            in.close();
            server.close();
            System.out.println("chiusura connessione");
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}