        /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_01;

import caelum.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author LUCIANO
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        ServerSocket servidor = new ServerSocket(12345);
        
        System.out.println("Porta 12345 aberta!");
        
        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " +
            cliente.getInetAddress().getHostAddress()
        );
        
        Scanner scanner = new Scanner(cliente.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        
        scanner.close();
        cliente.close();
        servidor.close();
    }
}
