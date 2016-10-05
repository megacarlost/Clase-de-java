/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedioSemestre;

/**
 *
 * @author Carlos
 */
public class Accion1 implements Runnable
{

    
    Convertir c1;
            @Override
            public void run() {
               System.out.println("De decimal a binario"); 
                System.out.println((c1.resultado));
            }
            public void sett1(Convertir c1){
                this.c1 = c1;
            }   

    
}

