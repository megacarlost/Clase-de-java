/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class SocketServer 
{
    public static ServerSocket server;
    public static Socket connection;
    
    protected final static int port = 19999;
    public static StringBuffer mensaje;
    
    public static void main(String[] args) 
    {
        int caracter;
        try 
        {
            server = new ServerSocket(port);
            while(true)
            {
                connection = server.accept();
                BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
                InputStreamReader isr = new InputStreamReader(bis);
                
                mensaje = new StringBuffer();
                while((caracter = isr.read()) != 13)
                {
                    mensaje.append((char)caracter);
                    
                }
                
                System.out.println("mensaje recibido: " + mensaje);
                String mensajeRetorno = "El servidor leyó tu mensaje: " + mensaje +(char)13; 
                BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
                OutputStreamWriter osw = new OutputStreamWriter(bos);
                osw.write(mensajeRetorno);
                osw.flush();
                
                
            }
        } 
        
        catch (IOException ex) 
        {
            
        }
    }
}
