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
import model.BeanRemedio;

/**
 *
 * @author Avell B153
 */
public class DAOAnuncio {

    private Connection conn;

    public DAOAnuncio(boolean logado) throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public void adiciona(String email, int id_remedio, Date data) throws XolerDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        String SQL;
        conn = this.conn;

        GregorianCalendar calendario = new GregorianCalendar();
        String d = "" + calendario.get(GregorianCalendar.DATE);
        String m = "" + (calendario.get(GregorianCalendar.MONTH) + 1);
        String y = "" + calendario.get(GregorianCalendar.YEAR);

        try {
            SQL = "INSERT INTO anuncio(email,id_remedio,data)"
                    + "VALUES ('" + email + "','" + id_remedio + "',STR_TO_DATE('" + d + '/' + m + '/' + y + "','%d/%m/%Y'));";

            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir dados " + sqle);
            throw new XolerDAOException("Erro ao inserir dados " + sqle);

        } finally {
            BDConnection.closeConnection(conn, ps);
        }

    }

    public BeanAnuncio busca_por_id(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT * FROM anuncio WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            try {
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id_rem = rs.getInt("id_remedio");
                    String email = rs.getObject("email").toString();
                    String data = rs.getObject("data").toString();

                    BeanAnuncio novo = new BeanAnuncio(email, id_rem, data);
                    return novo;
                }
            } catch (SQLException sqle) {
                throw new XolerDAOException("Erro ao buscar dados " + sqle);
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
        return null;

    }

    public List<BeanRemedio> busca_por_user(String email) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;

        try {
            String SQL = "SELECT * FROM anuncio,remedio WHERE anuncio.id_remedio = remedio.id_remedio AND anuncio.email = '" + email + "';";

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                int id_remedio = rs.getInt("id_remedio");
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                float preco = rs.getFloat("preco");
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");
                String tipo = rs.getObject("tipo").toString();
                int inativo = rs.getInt("inativo");

                novo = new BeanRemedio(id_remedio, nome, descricao, validade, preco, foto, um_id, tipo, inativo);

                list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }

    public void remove(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "DELETE FROM anuncio WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

}
