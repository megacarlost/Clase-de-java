/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class MultiThreadServer 
{
    public static final int port = 19999;
    public static void main(String[] args) 
    {
        try {
            ServerSocket ss = new ServerSocket(port);
            Socket connection;
            while(true)
                {
                    System.out.println("Servidor esperando coexiones");
                    connection = ss.accept();
                    System.out.println("Servidor recibió una peticion");
                    ProcessRequest request = new ProcessRequest(connection);
                    Thread t = new Thread(request);
                    t.start();
                }
            } 
        catch (IOException ex) 
        {
            
        }
        
    }
}
