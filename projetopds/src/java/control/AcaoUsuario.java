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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author Avell B153
 */
public class AcaoUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao.compareTo("adicionar") == 0) {
            try {
                acaoAdicionar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("avaliar") == 0) {
            try {
                acaoAvaliar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String senha = request.getParameter("senha");

        boolean logado = true;
        boolean erro = false;
        boolean usuarioExiste = false;

        try {
            DAOUsuario user = new DAOUsuario(logado);
            user.adiciona(nome, sobrenome, email, cpf, telefone, cep, rua, senha);

        } catch (XolerDAOException sqle) {
            erro = true;
        }

        RequestDispatcher rd = null;
        if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro durante o cadastro. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/cadastro.jsp");
        }
        if (usuarioExiste) {
            request.setAttribute("msgCadastro", "Email já cadastrado!");
            rd = request.getRequestDispatcher("/cadastro.jsp");
        }
        if (!erro && !usuarioExiste) {
            request.setAttribute("msgCadastro", "Cadastro efetuado com sucesso!");
            rd = request.getRequestDispatcher("/index.jsp");
        }

        enviar_email(email, nome);
        response.sendRedirect("index.jsp");
    }

    private void enviar_email(String email, String nome) throws XolerDAOException {

        SendGrid sendgrid = new SendGrid("andrermitsuoka@gmail.com", "3teptep3!");

        SendGrid.Email sendgrid_email = new Email();
        sendgrid_email.addTo(email);
        sendgrid_email.setFrom("andrermitsuoka@gmail.com");
        sendgrid_email.setSubject("Cadastro no Drograria.Me");

        sendgrid_email.setText(nome + ", Obrigado por se cadastrar no Drogaria.Me! :D ");

        try {
            SendGrid.Response response_sendgrid = sendgrid.send(sendgrid_email);
            System.out.println(response_sendgrid.getMessage());
        } catch (SendGridException e) {
            System.err.println(e);
        }

    }

    private void acaoAvaliar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        String nota = request.getParameter("notaUsuario");
        String usuario_dono = request.getParameter("dono");

        boolean logado = true;
        boolean erro = false;
        boolean usuarioExiste = false;
        
        try{
            DAOUsuario user = new DAOUsuario(logado);
            user.avalia(nota,usuario_dono);
        }catch(XolerDAOException sqle){
            erro = true;
        }

        RequestDispatcher rd = null;
        response.sendRedirect(request.getHeader("Referer"));
    }
}
