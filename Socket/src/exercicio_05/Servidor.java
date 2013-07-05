/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        
        ServerSocket servidor = new ServerSocket(12345);
        
        System.out.println("Porta 12345 aberta!");
        
        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " +
            cliente.getInetAddress().getHostAddress()
        );
        
        Thread.sleep(1000);
        
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        
        File arquivo = (File) ois.readObject();
        
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String linha = "";
        
        while((linha = bufferedReader.readLine()) != null){
            System.out.println(linha);
        }
        
        
        fileReader.close();
        bufferedReader.close();
        ois.close();
        cliente.close();
        servidor.close();
    }
}
