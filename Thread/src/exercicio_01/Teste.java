/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_01;

import caelum.*;

/**
 *
 * @author LUCIANO
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Programa p1 = new Programa();
        p1.setId(1);
        
        Thread t1 = new Thread(p1);
        t1.start();
        
        Programa p2 = new Programa();
        p1.setId(1);
        
        Thread t2 = new Thread(p2);
        t2.start();
    }
}
