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
public class BeanRemedio {
    
    public BeanRemedio(){        
    }

    public BeanRemedio(int id_remedio, String nome, String descricao, String validade, float preco, String foto, int um_id, String tipo, int inativo) {
        this.id_remedio = id_remedio;
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.preco = preco;
        this.foto = foto;
        this.um_id = um_id;
        this.tipo = tipo;
        this.inativo = inativo;
    }

    public BeanRemedio(String nome, String descricao, String validade, float preco, String foto, int um_id) {
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.preco = preco;
        this.foto = foto;
        this.um_id = um_id;
    }

    public BeanRemedio(int id_remedio, String nome, String descricao, String shortDescricao, String validade, float preco, int centavos, int real, String foto, int um_id, int inativo) {
        this.id_remedio = id_remedio;
        this.nome = nome;
        this.descricao = descricao;
        this.shortDescricao = shortDescricao;
        this.validade = validade;
        this.preco = preco;
        this.centavos = centavos;
        this.real = real;
        this.foto = foto;
        this.um_id = um_id;
        this.inativo = inativo;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValidade() {
        //validade = validade.replace("-","/");
        String ano, mes, dia, valid;
        //ano = validade.substring(0, 4);
        //mes = validade.substring(5, 7);
        //dia = validade.substring(8, 10);
        //valid = dia + "/" + mes + "/" + ano;
        
        String[] saida = validade.split("-");  
        //Ticianne  

        valid = saida[2] + "/" + saida[1] + "/" + saida[0];
        return valid;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getUm_id() {
        return um_id;
    }

    public void setUm_id(int um_id) {
        this.um_id = um_id;
    }        

    public int getCentavos() {
        float aux = (preco%1);
        centavos = (int) (aux * 100);
        return centavos;
    }

    public void setCentavos(int centavos) {
        this.centavos = centavos;
    }

    public int getReal() {
        real = (int) preco;
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public String getShortDescricao() {
        if(descricao.length() > 25){
            shortDescricao = descricao.substring(0,24);
            shortDescricao = shortDescricao + "...";
    }else
        shortDescricao = this.descricao;
       
        return shortDescricao;
    }

    public void setShortDescricao(String shortDescricao) {
        this.shortDescricao = this.descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }        
    
    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }
    
    int id_remedio;
    String nome;
    String descricao;
    String shortDescricao;
    String validade;
    float preco;
    int centavos;
    int real;
    String foto;
    int um_id;
    String tipo;
    int inativo;
}
