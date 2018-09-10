package javaapplication19;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class JavaApplication19 {

    public static void main(String[] args)  
    {  
        while (true)
        {
                try(ServerSocket server = new ServerSocket(1300);
                    Socket socket = server.accept();                    
                    InputStream input = socket.getInputStream();
                    OutputStream output = socket.getOutputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter pr = new PrintWriter(output, true);)
                    {
                    int a = Integer.parseInt(br.readLine().trim());
                    int b = Integer.parseInt(br.readLine().trim());    
                    int rezultat = a + b;
                    pr.println(String.valueOf(rezultat).trim());  
                } catch (IOException ex) {
                    ex.getMessage();
                }   
        } 
        }
    }