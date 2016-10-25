/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServidor;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Carlos
 */
public class Principal extends JFrame {
    JTextField campoTexto;
    JTextArea areaTexto;
    static ServerSocket server;
    static Socket connection;
    static int port = 19999;
    
    
    static  Principal main;

    public Principal() {
        super("Servidor");
        campoTexto = new JTextField();
        add(campoTexto, BorderLayout.NORTH);
        
        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);
    }
     public void mostrarMensaje(String mensaje)
    {
        areaTexto.append(mensaje);
    }
    
    public static void main(String[] args) {
        main = new Principal();
        
        ExecutorService executor = Executors.newCachedThreadPool();
                try {
                    
                    server = new ServerSocket(port);
                    main.mostrarMensaje("Servidor esperando cliente de chat");
                    while(true)
                    {
                    connection =  server.accept();
                    main.mostrarMensaje("conectado a " + connection.getInetAddress().getHostName());
                        executor.execute(new ThreadRecibe(connection, main));
                        executor.execute(new ThreadEnvia(connection, main));
                    }
                
             } catch (IOException ex) {
                    
             }
                executor.shutdown();
    }
    
    
}