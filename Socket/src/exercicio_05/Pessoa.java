/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_05;

import java.io.Serializable;

/**
 *
 * @author LUCIANO
 */
public class Pessoa implements Serializable{
    
    private String nome;
    private Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
}
