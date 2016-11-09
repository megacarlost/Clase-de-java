package SegundoParcialCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class PrincipalChat extends JFrame{
    public JTextField campoTexto; 
    public JTextArea areaTexto; 
    private static ServerSocket servidor; 
    private static Socket cliente; 
    private static String ip = "127.0.0.1"; 
    public static PrincipalChat main; 
    
    public PrincipalChat(){
        super("Cliente"); 
 
        campoTexto = new JTextField(); 
        campoTexto.setEditable(false); 
        add(campoTexto, BorderLayout.NORTH); 
        
        
        areaTexto = new JTextArea(); 
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setBackground(Color.orange); 
        areaTexto.setForeground(Color.BLACK); 
        campoTexto.setForeground(Color.BLACK); 
       
        
       
        JMenu menuArchivo = new JMenu("Archivo"); 
        JMenuItem salir = new JMenuItem("Salir");
        menuArchivo.add(salir);
        
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra); 
        barra.add(menuArchivo); 
        
        
        salir.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); 
                }
        });
        
        setSize(300, 320); 
        setVisible(true); 
    }
    
    
    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    } 
    public void habilitarTexto(boolean editable) {
        campoTexto.setEditable(editable);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrincipalChat main = new PrincipalChat(); 
        main.setLocationRelativeTo(null);   
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ExecutorService executor = Executors.newCachedThreadPool(); 
 
        try {
            main.mostrarMensaje("Buscando Servidor ...");
            cliente = new Socket(InetAddress.getByName(ip), 11111); 
            main.mostrarMensaje("Conectado a :" + cliente.getInetAddress().getHostName());
    
            main.habilitarTexto(true); 
            
            
            executor.execute(new ThreadRecibe(cliente, main));
            executor.execute(new ThreadEnvia(cliente, main)); 
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
        executor.shutdown();
    }

    class areaTexto {

        public areaTexto() {
        }
    }
}
