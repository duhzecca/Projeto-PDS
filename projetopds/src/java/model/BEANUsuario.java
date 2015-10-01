/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Avell B153
 */
public class BEANUsuario {
    
    public BEANUsuario(String email, String nome, String senha){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    
    public BEANUsuario(String email, String nome, float classificacao){
        this.email = email;
        this.nome = nome;
        this.classificacao = classificacao;
    }
    


    public String getNome() {
        String primeiro_nome;
        if(nome.length()>10){
            primeiro_nome = nome.substring(0, 10);
            return primeiro_nome;
        } else
            return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public float getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
    }

    public int getNum_avaliacoes() {
        return num_avaliacoes;
    }

    public void setNum_avaliacoes(int num_avaliacoes) {
        this.num_avaliacoes = num_avaliacoes;
    }   
    
    private String nome;    
    private String email;  
    private String senha;
    private String sobrenome;
    private int cpf;
    private String telefone;
    
    private int cep;
    private String rua;
    
    private float classificacao;
    private int num_avaliacoes;
}
