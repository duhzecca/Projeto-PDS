/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import java.sql.*;
//import model.XolerDAOException;
/**
 *
 * @author Avell B153
 */
public class testeDB {
    
    private Connection conn;

    //Objeto usado para enviar comandos SQL no SGBD
    private Statement stmt;

    public testeDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String conexao = "jdbc:mysql://localhost/pds";
            String usuario = "root";
            String senha = "";
            PreparedStatement ps = null;
            String SQL = "INSERT INTO usuario(email,nome,sobrenome,cpf,telefone,cep,rua,senha,classificacao)"
                    + "VALUES ('duhzecca@gmail.com','Eduardo','Zecca','33969565839','11111111111','18055-125','Avenida Juninho','123456',0);";
            System.out.println(SQL);
            conn = DriverManager.getConnection(conexao, usuario, senha);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(SQL);
            try {
                ps = conn.prepareStatement(SQL);
                ps.executeUpdate();
            } catch (SQLException sqle) {
                //throw new XolerDAOException("Erro ao inserir dados " + sqle);
            }
            System.out.println("ConexÃ£o OK!!!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro");
        }

    }

    public static void main(String args[]) {
        testeDB t = new testeDB();
    }

}
