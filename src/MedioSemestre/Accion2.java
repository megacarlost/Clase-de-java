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
public class Accion2 implements Runnable
{
    Convertir c2;
   
    
        
        public void run() {
            System.out.println("De decimal a octal");
            System.out.println((c2.resultado));
        }
            public void sett2(Octal o1){
                this.c2 = c2;
            }
        
}
