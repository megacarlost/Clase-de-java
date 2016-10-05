/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedioSemestre;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Carlos
 */
public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrera1;
        CyclicBarrier barrera2;
        
     Accion1 accionArealizar = new Accion1();   
     Accion2 accionArealizar2 = new Accion2();       
            
    barrera1 = new CyclicBarrier(2, (Runnable) accionArealizar);  
    barrera2 = new CyclicBarrier(2, (Runnable) accionArealizar2);
      
    Convertir h1 =  new Convertir(10, barrera1);
    Octal h2 = new Octal(10, barrera2);
   
    accionArealizar.sett1(h1);
    accionArealizar2.sett2(h2);
    
    new Thread(h1).start();
    new Thread(h2).start();
    }
}

