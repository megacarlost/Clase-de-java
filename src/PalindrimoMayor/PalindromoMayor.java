/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PalindrimoMayor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class PalindromoMayor extends Thread
{
    int mayor;
    int limInferior;
    int limSuperior;
    public PalindromoMayor(int limInferior, int limSuperior, int mayor)
    {
        this.limInferior = limInferior;
        this.limSuperior = limSuperior;
        this.mayor = mayor;
    }
    boolean isPalindrome(Integer num)
    {
        
        String reversa = new String();
        String n = num.toString();
        for(int i= n.length()-1; i >= 0; i--)
        {
           reversa = reversa + n.charAt(i);
        }
        if(reversa.equals(n))
            return true;
        return false;
    }
    

    @Override
    public void run() 
    {
        for(int i = limInferior; i <= limSuperior; i++)
        {
            for(int j = 100; j<1000; j++)
            {
               int temp = i*j;
               if(isPalindrome(temp))
               {
                   if(temp > mayor)
                   {
                       mayor = temp;
                   }
               }
            }
        }
    }
    
    public int getMayor()
    {
        return mayor;
    }
  

        public static void main(String[] args)
        {
            int mayor = 0;
            PalindromoMayor[]t = new PalindromoMayor[9];
            for (int i=0; i<9; i++)
            {
                t[i] = new PalindromoMayor((i+1)*100, ((i+1)*100)+99, mayor);
                t[i].start();
                try {
                    t[i].join();
                } catch (InterruptedException ex) {
                    
                }
            }
            
            for (int i = 0; i<9; i++)
            {
                if(t[i].getMayor() > mayor)
                {
                    mayor = t[i].getMayor();
                    System.out.println("mayor " + mayor);
                }
            }
            System.out.println("El mayor fue: " + mayor);
            
        }
}