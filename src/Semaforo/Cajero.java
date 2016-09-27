/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Carlos
 */
public class Cajero 
{
    void depositar(int cantidad) throws InterruptedException
    {
        
        System.out.println("El único cajero está depositando " + cantidad);
        sleep((long)(Math.random()%1000));
        System.out.println("Terminé la operacion");
    }
    
    void retirar(int cantidad) throws InterruptedException
    {
        System.out.println("El único cajero está retirando " + cantidad);
        sleep((long)(Math.random()%1000));
        System.out.println("Terminé la operacion");
    }
    
    void getSaldo(int cuenta) throws InterruptedException
    {
        Random r = new Random();
        System.out.println("El saldo de la cuenta: " + cuenta +" es " + r.nextInt()%1000+1);
        sleep((long)(Math.random()%1000));
        System.out.println("Terminé la operacion");
    }
    
    void pagar(int cuenta, int cantidad) throws InterruptedException
    {
        System.out.println("abonando " + cantidad + "a la cuenta " + cuenta);
        sleep((long)(Math.random()%1000));
        System.out.println("Terminé la operacion");
    }
}

