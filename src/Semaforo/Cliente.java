/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Cliente extends Thread 
{
    Semaphore cajero;
    Cajero personaCajero;

    public Cliente(Semaphore cajero, Cajero personaCajero) 
    {
        this.cajero = cajero;
        this.personaCajero = personaCajero;
    }
    
    void realizarOperacion() throws InterruptedException
    {
        Random r = new Random();
        float probabilidad = r.nextFloat();
        if(probabilidad<0.25f)
         {
            personaCajero.depositar((int) (Math.random()%10000));
         }   
         if((probabilidad>=0.25f)&&(probabilidad<0.5f))
         {
             personaCajero.retirar((int) (Math.random()%10000));
         }
         if((probabilidad>=0.5f)&&(probabilidad<0.75f))
         {
             personaCajero.getSaldo((int) (Math.random()%10000+1));
         }
         if((probabilidad>=0.75f)&&(probabilidad<1f))
         {
             personaCajero.pagar((int) (Math.random()%10000+1),(int) (Math.random()%10000+1));
         }
         
    }
    
    @Override
    public void run() 
    {
        try {
            cajero.acquire();
            realizarOperacion();
        }
        catch (InterruptedException ex) 
        {
            
        }
    }
    
}
