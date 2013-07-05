/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package broadcast_mensagem;

import java.io.IOException;
import java.io.InputStream;
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
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Digite seu nome: ");
        String nome = new Scanner(System.in).nextLine();
        new Cliente("127.0.0.1", 12345, nome).executa();
    }
    
    private String host;
    private int porta;
    private String nome;

    public Cliente(String host, int porta, String nome) {
        this.host = host;
        this.porta = porta;
        this.nome = nome;
    }
    
    public void executa() throws UnknownHostException, IOException{
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!\n");
        
        Recebedor recebedor = new Recebedor(cliente.getInputStream());
        new Thread(recebedor).start();
        
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while(teclado.hasNextLine()){
            saida.println(nome + ", disse: " + teclado.nextLine());
        }
        
        saida.close();
        teclado.close();
        cliente.close();
    }
    
    public class Recebedor implements Runnable{
       
        private InputStream servidor;
        
        public Recebedor(InputStream servidor){
            this.servidor = servidor;
        }

        @Override
        public void run() {
            Scanner scan = new Scanner(this.servidor);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        }
    }
}
