/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package broadcast_mensagem;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LUCIANO
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new Servidor(12345).executa();
    }
    
    private int porta;
    private List<PrintStream> clientes;

    public Servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }
    
    public void executa() throws IOException{
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta!");
        
        while(true){
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente" + 
                cliente.getInetAddress().getHostAddress()
            );
            
            PrintStream printStream = new PrintStream(cliente.getOutputStream());
            this.clientes.add(printStream);
            
            TrataCliente trataCliente = new TrataCliente(cliente.getInputStream(), this);
            new Thread(trataCliente).start();
            
        }
        
    }
    
    public void distribuiMensagem(String mensagem){
        for(PrintStream cliente : this.clientes){
            cliente.println(mensagem);
            if(cliente.checkError())
            	this.clientes.remove(cliente);
        }
    }
    
    public class TrataCliente implements Runnable{

        private InputStream cliente;
        private Servidor servidor;

        public TrataCliente(InputStream cliente, Servidor servidor) {
            this.cliente = cliente;
            this.servidor = servidor;
        }
        
        @Override
        public void run() {
            Scanner scanner = new Scanner(this.cliente);
            while(scanner.hasNextLine()){
                servidor.distribuiMensagem(scanner.nextLine());
            }
            scanner.close();
            servidor.distribuiMensagem("Um Cliente se Desconectou!");
            
        }
        
    }
}
