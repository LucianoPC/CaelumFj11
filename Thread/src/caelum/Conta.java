/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caelum;

/**
 *
 * @author LUCIANO
 */
public class Conta {
    
    private double saldo;
    
    public void atualiza(double taxa) {
        synchronized (this) {
            double saldoAtualizado = this.saldo * (1 + taxa);
            this.saldo = saldoAtualizado;
        }
    }
    
    public void deposita(double valor) {
        synchronized (this) {
            double novoSaldo = this.saldo + valor;
            this.saldo = novoSaldo;
        }
    }
}
