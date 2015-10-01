/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BeanRemedio;
import model.DAOAnuncio;
import model.XolerDAOException;

/**
 *
 * @author Eduardo Zecca
 */
public class AcaoAnuncio extends HttpServlet {

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

        String acao = request.getParameter("acao");        
        
        if (acao.compareTo("buscar") == 0) {
            try {
                acaoBuscar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void acaoBuscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        List<BeanRemedio> listaDeRemedios;
        String email = request.getParameter("email");
        

        try {
            DAOAnuncio remedios = new DAOAnuncio(true);
            listaDeRemedios = remedios.busca_por_user(email);
            request.setAttribute("listaTopRemedio1", listaDeRemedios);
        } catch (Exception sqle) {
            listaDeRemedios = new ArrayList<BeanRemedio>();
            request.setAttribute("listaTopRemedio1", listaDeRemedios);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/seusprodutos.jsp");
        
        rd.forward(request, response);
    }

}
