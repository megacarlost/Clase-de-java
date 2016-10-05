/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedioSemestre;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */

    public class Octal implements Runnable {
    public int Tamano;
    public int[] a;
    public int x;
    CyclicBarrier b2;

public Octal(int x, CyclicBarrier b2){
    this.x = x;
    this.b2 = b2;
}

    @Override
    public void run() {
    
            try{
        for ( int i = 0; i < Tamano; i++ )
 {  

 a[i] = 0;

 }  

 int j = 0;
    

 while ( 0 != x )

 {   

 if ( 0 != x % 8 )

 {   

 a[j++] = x % 8;

 x -= x % 8;

 x /= 8;

 }   

 else

 {    

 a[j++] = 0;
 
 x /= 8;

        }     b2.await();

           
    }
       
    } catch (InterruptedException ex) {
        
    } catch (BrokenBarrierException ex) {
        
    }
}    
}

