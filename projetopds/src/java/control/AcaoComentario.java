/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BeanComentario;
import model.DAOComentario;
import model.XolerDAOException;

/**
 *
 * @author Eduardo Zecca
 */
public class AcaoComentario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao.compareTo("listaComentarios") == 0) {
            try {
                acaoListaComentario(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } */

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
        }
    }

    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String email = request.getParameter("email");
        String string_id_remedio = request.getParameter("id_remedio");

        int id_remedio = Integer.parseInt(string_id_remedio);
        String descricao = request.getParameter("comentario");

        Date d = new Date();
        d = new Timestamp(d.getTime());
        

        
        boolean logado = true;
        boolean erro = false;
        int id;

        try {
            //ADICIONA O COMENTARIO
            DAOComentario comentario = new DAOComentario(logado);
            comentario.adiciona(email, id_remedio, descricao, d);
        } catch (XolerDAOException sqle) {
            System.out.println(sqle.getMessage());
            erro = true;
        }

        //RequestDispatcher rd = null;
        /*if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            request.setAttribute("msgCadastro", "Comentario efetuado com sucesso!");
            rd = request.getRequestDispatcher("/index.jsp");
        }*/

        response.sendRedirect("remedio?id="+id_remedio);
    }
/*
    private void acaoListaComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        List<BeanComentario> listaDeComentarios;
        String paginaOrigem = request.getParameter("paginaOrigem");

        try {
            DAOComentario comentarios = new DAOComentario(true);
            listaDeComentarios = comentarios.listaComentarios();
            request.setAttribute("listaComentario", listaDeComentarios);
        } catch (Exception sqle) {
            listaDeComentarios = new ArrayList<BeanComentario>();
            request.setAttribute("listaComentario", listaDeComentarios);
        }
        RequestDispatcher rd = null;
        if (paginaOrigem.equals("index")) {
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            rd = request.getRequestDispatcher("/index.jsp");
        }

        rd.forward(request, response);
    } */
}
