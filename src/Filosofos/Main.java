/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Carlos
 */
public class Main 
{
    
 
   
    final static int numeroFilosofos = 5;
 
   
    final static int[][] palillosFilosofo = {
        {0, 4},
        {1, 0}, 
        {2, 1}, 
        {3, 2}, 
        {4, 3} 
    };
 
   
    final static Semaphore[] palillos_semaforo = new Semaphore[numeroFilosofos];
 
    
    public static void main(String[] args) {
        for (int i = 0; i < numeroFilosofos; i++) {
            palillos_semaforo[i] = new Semaphore(1);
        }
 
        
        for (int idFilosofo = 0; idFilosofo < numeroFilosofos; idFilosofo++) {
            new Filosofo(idFilosofo, palillos_semaforo, palillosFilosofo).start();
        }
    }
}

