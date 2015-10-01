
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auxiliar.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;



/**
 *
 * @author Avell B153
 */
public class DAOLogin {
    
    private Connection conn;
    
    public DAOLogin() throws XolerDAOException{
        try{
            this.conn = BDConnection.getConnection(true);
        }catch(Exception e){
            throw new XolerDAOException("Erro: "+"\t "+e.getMessage());
        }
    }
    
    public BEANUsuario buscaUser(String email, String senha) throws XolerDAOException{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;                
        
        try{
            String SQL = "SELECT * FROM usuario WHERE email='"+email+"' AND senha='"+senha+"';";
            
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                BEANUsuario user = new BEANUsuario(
                        rs.getObject("email").toString(),
                        rs.getObject("nome").toString(),
                        rs.getObject("senha").toString());
                return user;
            }
            return null;
        }catch(SQLException sqle){
            throw new XolerDAOException(sqle);
        }finally{
            BDConnection.closeConnection(conn,ps,rs);
        }
    }
    
 
    
}

