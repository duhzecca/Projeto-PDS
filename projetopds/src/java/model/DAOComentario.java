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
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Eduardo Zecca
 */
public class DAOComentario {

    private Connection conn;

    public DAOComentario(boolean logado) throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public void adiciona(String email, int id_remedio, String descricao, Date data) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        if (email == null || descricao == null) {
            throw new XolerDAOException("O valor passado nao pode ser nulo");
        }
        
        GregorianCalendar calendario = new GregorianCalendar();
        String d = ""+calendario.get(GregorianCalendar.DATE);
        String m = ""+(calendario.get(GregorianCalendar.MONTH)+1);
        String y = ""+calendario.get(GregorianCalendar.YEAR);

        try {
            String SQL = "INSERT INTO comentario(email, id_remedio, descricao, data)"
                    + "VALUES('" + email + "','" + id_remedio + "', '" + descricao + "', STR_TO_DATE('"+d+'/'+m+'/'+y+"','%d/%m/%Y'));";;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            System.out.println(SQL);

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
    }

    public List<BeanComentario> listaComentarios(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanComentario novo = null;
        try {
            String SQL = "SELECT u.nome, c.descricao, c.data FROM usuario u, comentario c, remedio r WHERE u.email = c.email "
                    + "AND r.id_remedio = c.id_remedio AND r.id_remedio = "+id+" ORDER BY c.id_comentario;";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanComentario> list = new ArrayList<BeanComentario>();
            
            while (rs.next()) {
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String data = rs.getObject("data").toString();                

                novo = new BeanComentario(nome, descricao, data);
                list.add(novo);
            }
            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
    

}
