/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedioSemestre;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Convertir implements Runnable{
    public int temp;
    public String resultado;
    CyclicBarrier b1;
    
    public Convertir(int numeroDecimal, CyclicBarrier b1){ 
       this.temp = numeroDecimal;
       this.resultado = "";
       this.b1 = b1;
   
    }


    @Override
        public void run(){
            
         try {    
             
        while (temp != 0){ 
            
            if(temp % 2 == 0){
                resultado = "0" + resultado;
            }else{
                resultado = "1" + resultado; 
            } 
            temp = temp / 2;      
           
        }   b1.await();
        
            
        } catch (InterruptedException ex) {
            
        } catch (BrokenBarrierException ex) {
           
        }
    } 
}