/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author Carlos
 */
public class Pair <K, V> 
{
     private K key;
     private V value;

    public Pair(K key, V value) 
    {
        this.key = key;
        this.value = value;
    }

     
    
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public static void main(String[] args)
    {
        Pair<Integer, String> par1 = new Pair(1, "Miroslava"); 
        Pair<Integer, String> par2 = new Pair(2, "Melissa"); 
        Pair<Integer, String> par3 = new Pair(3, "Aquiles"); 
        Pair<Integer, String> par4 = new Pair(4, "Omega"); 
        Pair par5 = new Pair("Hola", 3.14);
        System.out.println("Key:" + par1.getKey() + " Value: " + par1.getValue());
    }
}
