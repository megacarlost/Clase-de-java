/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreadSocket;

import Sockets.SocketClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Carlos
 */
public class TestServer 
{
    public static void main(String[] args) 
    {
        for(int i =0; i<100; i++)
        {
            Runnable r = new Runnable() {
                @Override
                public void run() 
                {       
System.out.println("Soy el server y estoy esperando un cliente");
        try {
            String host = "localhost";
            int port = 19999;
            
            StringBuffer mensaje = new StringBuffer();
            InetAddress ia = InetAddress.getByName(host);
            Socket connection = new Socket(ia, port);
            
            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(bos);
            
            String temp = "Soy el cliente 1, ayuuuuuuuuuuuda " + (char)13;
            osw.write(temp);
            osw.flush();
            
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(bis);
            
            int caracter;
            
            while((caracter=isr.read()) != 13)
            {
                mensaje.append((char)caracter);
            }
            
            System.out.println(mensaje);
            connection.close();
            
                    
        } 
        
        catch(UnknownHostException ex)
        {
            
        }
        
        catch (IOException ex) {
            
        }               
                }
            };
            Thread t = new Thread();
        }
    }
    
}
