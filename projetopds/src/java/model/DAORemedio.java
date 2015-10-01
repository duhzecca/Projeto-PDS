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
import java.util.List;

/**
 *
 * @author Eduardo Zecca
 */
public class DAORemedio {

    private Connection conn;

    public DAORemedio(boolean logado) throws XolerDAOException {
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public int adiciona(String nome, String descricao, String validade, float preco, String foto, int um_id,String tipo)
            throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        if (nome == null) {
            throw new XolerDAOException("O valor passado nao pode ser nulo");
        }

        int id = 0;

        //System.out.println("adicionaaa \n\n\n");

        try {
            String SQL = "INSERT INTO remedio(nome,descricao,validade,preco,foto,um_id,tipo)"
                    + "VALUES('" + nome + "','" + descricao + "',STR_TO_DATE('" + validade + "','%d/%m/%Y'),'" + preco + "','" + foto + "','" + um_id + "','" + tipo + "');";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);            

            try {
                ps.executeUpdate();
            } catch (SQLException sqle) {
                System.out.println("Erro ao inserir dados " + sqle.getMessage());
                throw new XolerDAOException("Erro ao inserir dados " + sqle.getMessage());
            }

            SQL = "SELECT LAST_INSERT_ID()  as last_id from remedio;";
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                String last = rs.getString("last_id");
                id = Integer.parseInt(last);
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }

        return id;
    }

    public void altera(int id, String novaDesc, String novoPreco, String novaFoto) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            String SQL = "UPDATE remedio SET descricao = '" + novaDesc + "', preco = '" + novoPreco + "', foto = '" + novaFoto
                    + "' WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            try {
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new XolerDAOException("Erro ao alterar dados " + sqle);
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public BeanRemedio busca_por_id(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT * FROM remedio WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            try {
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id_rem = rs.getInt("id_remedio");
                    String nome = rs.getObject("nome").toString();
                    String descricao = rs.getObject("descricao").toString();
                    String validade = rs.getObject("validade").toString();
                    float preco = rs.getFloat("preco");
                    String foto = rs.getObject("foto").toString();
                    int um_id = rs.getInt("um_id");
                    String tipo = rs.getObject("tipo").toString();
                    int inativo = rs.getInt("inativo");

                    BeanRemedio novo = new BeanRemedio(id_rem, nome, descricao, validade, preco, foto, um_id, tipo, inativo);
                    
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

    public BEANUsuario usuario_por_id(int id_remedio) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = BDConnection.getConnection(true);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }

        ResultSet rs = null;

        try {
            String SQL = "SELECT u.email,u.nome, u.classificacao FROM anuncio a,usuario u WHERE a.id_remedio = '" + id_remedio + "' AND a.email = u.email;";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            //System.out.println(SQL);

            try {
                rs = ps.executeQuery();
                while (rs.next()) {

                    String nome = rs.getObject("nome").toString();
                    String email = rs.getObject("email").toString();
                    float classificacao = Float.parseFloat(rs.getObject("classificacao").toString());

                    BEANUsuario novo = new BEANUsuario(email, nome, classificacao);
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

    public void remove(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new XolerDAOException("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "DELETE FROM remedio WHERE id_remedio = '" + id + "';";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao remover dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public List<BeanRemedio> consultaNome(String buscanome) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;
        
        try {
            //Define consulta
            String SQL = "SELECT * from remedio WHERE nome LIKE '%" + buscanome + "%';";
            //System.out.println(SQL);
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                int id_rem = rs.getInt("id_remedio");
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                float preco = rs.getFloat("preco");
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");
                String tipo = rs.getObject("tipo").toString();
                int inativo = rs.getInt("inativo");

                novo = new BeanRemedio(id_rem, nome, descricao, validade, preco, foto, um_id, tipo, inativo);
                if(inativo == 1)
                    list.add(novo);
            }

            return list;
        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }

    public List<BeanRemedio> consultaPreco(int preco) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;
        String SQL;

        try {
            if (preco == 71) {
                SQL = "SELECT * FROM remedio WHERE (preco <= 70 OR preco > 70) ORDER BY preco;";
            } else {
                SQL = "SELECT * FROM remedio WHERE preco <= " + preco + " ORDER BY preco;";
            }

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                int id_remedio = rs.getInt("id_remedio");
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                float precoRemedio = rs.getFloat("preco");
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");
                String tipo = rs.getObject("tipo").toString();
                int inativo = rs.getInt("inativo");

                novo = new BeanRemedio(id_remedio, nome, descricao, validade, precoRemedio, foto, um_id,tipo, inativo);
                if(inativo == 1)
                    list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
    public List<BeanRemedio> filtraBuscaPreco(String busca, int preco, String tipo_param) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;
        String SQL;
        
        if(busca == null){
            busca = "zzzz";
        }
        System.out.println("Filtra Busca Preço Filtra Busca Preço");
        System.out.println(tipo_param);
        if ( tipo_param.equals("todos") )
            tipo_param = "";
        else 
            tipo_param = " AND (tipo ='"+tipo_param+"')";
            
        System.out.println(tipo_param);

        try {
            if (preco == 71) {
                SQL = "SELECT * FROM remedio WHERE nome LIKE '%" + busca + "%' AND (preco <= 70 OR preco > 70)"+tipo_param+ "ORDER BY preco;";
            } else {
                SQL = "SELECT * FROM remedio WHERE nome LIKE '%" + busca + "%' AND preco <= " + preco + tipo_param +" ORDER BY preco;";
            }
            
            //System.out.println(SQL);

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                int id_remedio = rs.getInt("id_remedio");
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                float precoRemedio = rs.getFloat("preco");
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");
                String tipo = rs.getObject("tipo").toString();
                int inativo = rs.getInt("inativo");

                novo = new BeanRemedio(id_remedio, nome, descricao, validade, precoRemedio, foto, um_id, tipo, inativo);
                if(inativo == 1)
                    list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
        public List<BeanRemedio> filtraBuscaTipo(String busca, String tipoRemedio) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;
        String SQL;
        
        if(busca == null){
            busca = "zzzz";
        }

        try {
            SQL = "SELECT * FROM remedio WHERE nome LIKE '%" + busca + "%' AND tipo = '" + tipoRemedio + "' ORDER BY preco;";
            
            //System.out.println(SQL);

            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<BeanRemedio> list = new ArrayList<BeanRemedio>();

            while (rs.next()) {
                int id_remedio = rs.getInt("id_remedio");
                String nome = rs.getObject("nome").toString();
                String descricao = rs.getObject("descricao").toString();
                String validade = rs.getObject("validade").toString();
                float precoRemedio = rs.getFloat("preco");
                String foto = rs.getObject("foto").toString();
                int um_id = rs.getInt("um_id");
                String tipo = rs.getObject("tipo").toString();
                int inativo = rs.getInt("inativo");

                novo = new BeanRemedio(id_remedio, nome, descricao, validade, precoRemedio, foto, um_id, tipo, inativo);
                if(inativo == 1)
                    list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }

    public List<BeanRemedio> listaTopRemedios() throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;

        try {
            String SQL = "SELECT * FROM remedio WHERE Inativo = 1 LIMIT 12;";

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
                if(inativo == 1)
                    list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
    public List<BeanRemedio> listaTopRemedios1() throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        BeanRemedio novo = null;

        try {
            String SQL = "SELECT * FROM remedio;";

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
                if(inativo == 1)
                    list.add(novo);
            }

            return list;

        } catch (SQLException sqle) {
            throw new XolerDAOException(sqle);
        } finally {
            BDConnection.closeConnection(conn, ps, rs);
        }
    }
    
    public void ativa(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            String SQL = "UPDATE remedio SET Inativo = 1 WHERE id_remedio = " + id + ";";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            System.out.println(SQL);
            try {
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new XolerDAOException("Erro ao alterar dados " + sqle);
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }

    public void inativa(int id) throws XolerDAOException {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            String SQL = "UPDATE remedio SET Inativo = 0 WHERE id_remedio = " + id + ";";
            System.out.println(SQL);
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            try {
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new XolerDAOException("Erro ao alterar dados " + sqle);
            }

        } catch (SQLException sqle) {
            throw new XolerDAOException("Erro ao alterar dados " + sqle);
        } finally {
            BDConnection.closeConnection(conn, ps);
        }
    }
}
