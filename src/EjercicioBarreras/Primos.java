/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioBarreras;

/**
 *
 * @author Carlos
 */
public class Primos 
{
    int x=0;
    
    public void getPrimo()
    {
        for(int i=0; i<10000; i++)
        {
            if((i%2!=0)||(i%3!=0))
            {
                x = x + i;
            }
        }
        System.out.println("El numero primo mayor es = " + x);
    }
    
    
}
