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
 * @author Mitsuoka
 */
public class DAOUnidadeMedida {
    private Connection conn;
    
    public DAOUnidadeMedida(boolean logado) throws XolerDAOException{
        try {
            this.conn = BDConnection.getConnection(logado);

        } catch (Exception e) {
            throw new XolerDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }         
    }
    
    
    public int adiciona(String tipo_unidade, int quantidade, int dose) throws XolerDAOException{

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        
        String SQL;
        conn = this.conn;
        
        int id=0;
        
        try{
            SQL = "INSERT INTO unidade_medida(tipo_unidade,quantidade_por_unidade,dose_por_unidade)"
                      + "VALUES ('"+tipo_unidade+"','"+quantidade+"','"+dose+"');";               
              ps = conn.prepareStatement(SQL);
              System.out.println(SQL);
              ps.executeUpdate(); 
              
              SQL = "SELECT LAST_INSERT_ID()  as last_id from unidade_medida;";
              ps = conn.prepareStatement(SQL);
              rs = ps.executeQuery();
              if(rs.next()){
                  String last = rs.getString("last_id");
                  id = Integer.parseInt(last);
              }
        }catch(SQLException sqle) {
            System.out.println("Erro ao inserir dados " + sqle);
            throw new XolerDAOException("Erro ao inserir dados " + sqle);
            
        }finally {
            BDConnection.closeConnection(conn,ps);
        }
        return id ;
        
        
    }
    
}
