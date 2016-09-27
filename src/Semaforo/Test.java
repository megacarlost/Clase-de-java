/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Carlos
 */
public class Test 
{
    public static void main(String[] args) 
    {
           Semaphore semCajero;
           semCajero = new Semaphore(100);
           Cajero cajero = new Cajero();
           Cliente[] usuarios  = new Cliente[100];           
           for(int i = 0;  i<100; i++)
           {
               usuarios[i] = new Cliente(semCajero, cajero);
               usuarios[i].start();
           }
    }
}
