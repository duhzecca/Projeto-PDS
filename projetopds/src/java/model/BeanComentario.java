/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Eduardo Zecca
 */
public class BeanComentario {

    BeanComentario(String nome, String descricao, String data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        String ano, mes, dia, valid;
        //ano = validade.substring(0, 4);
        //mes = validade.substring(5, 7);
        //dia = validade.substring(8, 10);
        //valid = dia + "/" + mes + "/" + ano;
        
        String[] saida = data.split("-");  
        //Ticianne  

        valid = saida[2] + "/" + saida[1] + "/" + saida[0];
        return valid;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
                
    int id_remedio;
    String nome;
    String email;
    String descricao;
    String data;
}
