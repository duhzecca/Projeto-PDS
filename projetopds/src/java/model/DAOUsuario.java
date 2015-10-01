/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import auxiliar.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Avell B153
 */
public class DAOUsuario {

    private Connection conn;

    public DAOUsuario(boolean logado) throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public boolean adiciona(String nome, String sobrenome, String email, String cpf, String telefone, String cep, String rua, String senha) throws XolerDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean usuarioExiste = false;

        if (email == null) {
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }

        try {

            String SQL = "SELECT * FROM usuario WHERE email LIKE '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            System.out.println("dudu viado");

            try {
                rs = ps.executeQuery();

            } catch (Exception e) {
                System.out.println("dudu viado " + e);

            }
            System.out.println("dudu viado");

            if (!rs.next()) {
                System.out.println("dudu viado");

                SQL = "INSERT INTO usuario(email,nome,sobrenome,cpf,telefone,cep,rua,senha,classificacao,num_avaliacoes)"
                        + "VALUES ('" + email + "','" + nome + "','" + sobrenome + "','" + cpf + "','" + telefone + "','" + cep + "','" + rua + "','" + senha + "',0,0);";
                System.out.println(SQL);
                ps = conn.prepareStatement(SQL);
                System.out.println(SQL);
                ps.executeUpdate();
            } else {
                usuarioExiste = true;
            }
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
        return usuarioExiste;

    }

    public boolean nova_senha(String email, String senha) throws XolerDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean usuarioExiste = false;

        if (email == null) {
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }

        try {

            String SQL = "UPDATE usuario SET senha=" + senha + " WHERE email LIKE '" + email + "';";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);

            try {
                ps.executeUpdate();

            } catch (Exception e) {
                System.out.println("dudu viado " + e);

            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
        return usuarioExiste;

    }

    public boolean avalia(String nota, String usuario_dono) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean usuarioExiste = false;
        float notaFloat = Float.parseFloat(nota);
        float notaAcumulada = 0;
        int num_avaliacoes = 0;
        float media;        
        
        if(usuario_dono == null){
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        
        try {

            String SQL = "SELECT classificacao, num_avaliacoes FROM usuario WHERE email LIKE '" + usuario_dono + "';";
            System.out.println("QUERY 1: " + SQL);
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                notaAcumulada = rs.getFloat("classificacao");
                num_avaliacoes = rs.getInt("num_avaliacoes");
            }
            
            notaFloat = notaFloat + notaAcumulada;
            num_avaliacoes = num_avaliacoes + 1;
            
            media = notaFloat / 2;

            SQL = "UPDATE usuario SET classificacao=" + media + ", num_avaliacoes=" + num_avaliacoes + " WHERE email LIKE '" + usuario_dono + "';";
            ps = conn.prepareStatement(SQL);
            System.out.println("QUERY 2: " + SQL);
            try {
                ps.executeUpdate();                
            } catch (SQLException sqle) {
                System.out.println("Erro ao inserir dados " + sqle.getMessage());
                throw new XolerDAOException("Erro ao inserir dados " + sqle.getMessage());
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
        return usuarioExiste;
        
    }
}
