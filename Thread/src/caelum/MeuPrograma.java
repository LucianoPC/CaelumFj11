/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

/**
 *
 * @author LUCIANO
 */
public class MeuPrograma {
    public static void main (String[] args) {
        GeraPDF gerapdf = new GeraPDF();
        Thread threadDoPdf = new Thread(gerapdf);
        threadDoPdf.start();
        BarraDeProgresso barraDeProgresso = new BarraDeProgresso();
        Thread threadDaBarra = new Thread(barraDeProgresso);
        threadDaBarra.start();
    }
}
