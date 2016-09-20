/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Ethread extends Thread
{
    private int id;

    public Ethread(int id) {
        this.id = id;
    }

    @Override
    public void run() 
    {
        Random r = new Random();
        System.out.println("Soy el hilo" + id);
        try
        {
            System.out.println("hilo: " + id + " está prendido");
            int tiempo = r.nextInt(29000)+1000;
            System.out.println("tiempo: " + tiempo);
            sleep(tiempo);
            System.out.println("hilo " + id + " finalidazo");
        }
        catch(InterruptedException ex)
                {
                    
                }
    }
    
    public static void main(String[] args) 
    {
       Thread t100 = new Thread(new Runnable()
       {
           @Override
           public void run()
           {
               System.out.println("No soy demonio");
               try
               {
                   sleep(5000);
                   System.out.println("finaliza");
               }
               catch(InterruptedException ex)
               {
                   
               }
           }
       });
       
       t100.start();
        
       Thread t1 = new Ethread(1);
       t1.setPriority(MAX_PRIORITY);
       t1.start();
       t1.setDaemon(true);
       (new Ethread(2)).start();
       (new Ethread(3)).start();
       (new Ethread(4)).start();
        
 
    }
    
}
