/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author LUCIANO
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException{
        
        Socket cliente = new Socket("127.0.0.1",12345);
        System.out.println("O cliente se conectou ao servidor!");
        
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }
        saida.close();
        teclado.close();
    }
}
