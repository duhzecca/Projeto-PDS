/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.XolerDAOException;
/**
 *
 * @author Avell B153
 */
public class BDConnection {
    public static Connection getConnection(boolean logado) throws XolerDAOException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //String conexao = "jdbc:mysql://mysql-xoler.jelastic.websolute.net.br/xoler";
            //String usuario, senha;
            String conexao = "jdbc:mysql://localhost/pds";
            String usuario, senha;
            if(logado){
                usuario = "root";
                senha = "";
            }else{
                usuario = "x";
                senha = "x";
            }
            Connection conn = DriverManager.getConnection(conexao, usuario, senha);
            System.out.println("ConexÃ£o OK!!!");
            return conn;
        } catch (Exception e) {
            throw new XolerDAOException(e.getMessage());
        }
    
    }
    
    public static void closeConnection(Connection conn, Statement stmt)
            throws XolerDAOException {
        close(conn, stmt, null);
    }
    
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws XolerDAOException {
        close(conn, stmt, rs);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs)
            throws XolerDAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new XolerDAOException(e.getMessage());
        }
    }
}
