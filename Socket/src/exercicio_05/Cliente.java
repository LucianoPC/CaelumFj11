/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_05;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author LUCIANO
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        
        Socket cliente = new Socket("127.0.0.1", 12345);
        
        File arquivo = new File("ArquivoTransferido.txt");
        
        ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
        
        oos.writeObject(arquivo);
        
        Thread.sleep(5000);
        
        oos.close();
        cliente.close();       
        
    }
}
