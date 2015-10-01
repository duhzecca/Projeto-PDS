/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sendgrid.*;
import com.sendgrid.SendGrid.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author Avell B153
 */
public class ValidaLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String acao = request.getParameter("acao");
        
        if(acao.compareTo("login") == 0){

        }else if(acao.compareTo("logout") == 0){
            logout(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                
        String acao = request.getParameter("acao");
        if(acao.compareTo("login") == 0){
            login(request, response);
        }else if(acao.compareTo("logout") == 0){
            logout(request, response);
        }else if(acao.compareTo("novasenha") == 0){
            try {
                nova_senha(request,response);

            } catch (XolerDAOException ex) {
                Logger.getLogger(ValidaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void nova_senha(HttpServletRequest request,HttpServletResponse response) throws XolerDAOException, IOException{
        String email = request.getParameter("email");
        SendGrid sendgrid = new SendGrid("andrermitsuoka@gmail.com","3teptep3!");
        
        SendGrid.Email sendgrid_email = new Email();
        sendgrid_email.addTo(email);
        sendgrid_email.setFrom("andrermitsuoka@gmail.com");
        sendgrid_email.setSubject("Nova Senha");
        

        
        DAOUsuario user = new DAOUsuario(true);

        int hash = email.hashCode();
        String novasenha = Integer.toString(Math.abs(hash));
        System.out.println("novasenha");

        System.out.println(novasenha);
        user.nova_senha(email, novasenha);
        sendgrid_email.setText("Sua nova senha no Drogaria.me é: "+novasenha);

        

        try {
            SendGrid.Response response_sendgrid = sendgrid.send(sendgrid_email);
            System.out.println(response_sendgrid.getMessage());
        }
        catch (SendGridException e) {
            System.err.println(e);
        }
        
        response.sendRedirect("index.jsp");
        
    }
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("usuarioLogin");
        String senha = request.getParameter("senhaLogin");

        //if deve verificar se usuario existe pelo banco de dados
        BEANUsuario user;
        
        try{
            DAOLogin loga = new DAOLogin();
            user = loga.buscaUser(login, senha);
        }catch(Exception sqle){
            user = null;
        }

        if(null != user){
            HttpSession session = request.getSession(); //sem parametro false, portanto se tiver outra sessao criada ele destroi
            session.setAttribute("Usuario", user);
            response.sendRedirect(request.getHeader("Referer"));
                    
        }else{
            response.sendRedirect("loginfail.jsp");
        }

        
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }


}
