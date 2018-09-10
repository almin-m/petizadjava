
package javaapplication19;

import java.awt.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

public class Client {
    
    public static void main(String[] args)  {
        
        
        Frame f = new Frame ("Sabiranje");
        TextField tf1 = new TextField("   ");
        TextField tf2 = new TextField("   ");
        TextField tf3 = new TextField("   ");
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        
        f.addWindowListener(new WindowAdapter()
   {    public void windowClosing(WindowEvent we){
         System.exit(0);
         }
   });
         LayoutManager layOut = new FlowLayout();
        f.setLayout(layOut);
         Button button = new Button ("Calculate");
         
        
    button.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed (ActionEvent e)
        {
        
        try(Socket socket = new Socket("localhost", 1300);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pr = new PrintWriter(output, true);)
            {
                pr.println(tf1.getText().trim());
                pr.println(tf2.getText().trim());
                String rezultat = br.readLine().trim();
                tf3.setText(rezultat);              
            }   catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
    });

    f.add(button);
    f.setSize(400, 200);
    f.setVisible(true); 
     
    }
}