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
public class Calculadora 
{
    public<T extends Number> T sum(T a, T b)
    {   
        if(a.getClass().equals(Integer.class))
            return (T) new Integer(a.intValue() + b.intValue());
        if(a.getClass().equals(Double.class))
            return (T) new Double(a.doubleValue() + b.doubleValue());
        if(a.getClass().equals(Float.class))
            return (T) new Float(a.floatValue() + b.floatValue());
        return null;
    }
    
    public<T extends Number> T res(T c, T d)
    {   
        if(c.getClass().equals(Integer.class))
            return (T) new Integer(c.intValue() - d.intValue());
        if(c.getClass().equals(Double.class))
            return (T) new Double(c.doubleValue() - d.doubleValue());
        if(c.getClass().equals(Float.class))
            return (T) new Float(c.floatValue() - d.floatValue());
        return null;
    }
    
    public<T extends Number> T mult(T e, T f)
    {   
        if(e.getClass().equals(Integer.class))
            return (T) new Integer(e.intValue() * f.intValue());
        if(e.getClass().equals(Double.class))
            return (T) new Double(e.doubleValue() * f.doubleValue());
        if(e.getClass().equals(Float.class))
            return (T) new Float(e.floatValue() * f.floatValue());
        return null;
    }
    
    public<T extends Number> T div(T g, T h)
    {   
        if(g.getClass().equals(Integer.class))
            return (T) new Integer(g.intValue() - h.intValue());
        if(g.getClass().equals(Double.class))
            return (T) new Double(g.doubleValue() - h.doubleValue());
        if(g.getClass().equals(Float.class))
            return (T) new Float(g.floatValue() - h.floatValue());
        return null;
    }
    
    
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println("La suma es= " + c.sum(5,5));
        System.out.println("La resta es= " + c.res(10, 4));
        System.out.println("La multiplicacion es= " + c.mult(2, 5));
        System.out.println("La division es= " + c.div(4, 2));
    }
}
