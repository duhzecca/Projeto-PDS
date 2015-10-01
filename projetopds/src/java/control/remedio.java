/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BeanRemedio;
import model.*;

/**
 *
 * @author Avell B153
 */
public class remedio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet remedio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet remedio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int id_remedio = Integer.parseInt(id);
        DAORemedio n = null;
        DAORemedio n2 = null;

        BeanRemedio remedio = null;
        BEANUsuario usuario =  null;
        
        try {
            n = new DAORemedio(true);
            n2 = new DAORemedio(true);
        } catch (XolerDAOException ex) {
            Logger.getLogger(remedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
             remedio = n.busca_por_id(id_remedio);
             usuario = n2.usuario_por_id(id_remedio);
             if (usuario == null){
                 usuario = new BEANUsuario("null@null.com","Usuário Excluído",0);
             }
        } catch (XolerDAOException ex) {
            Logger.getLogger(remedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            
            DAOComentario coment = new DAOComentario(true);
            List <BeanComentario> comentarios = null;
            comentarios = coment.listaComentarios(remedio.getId_remedio());
            
            System.out.println(usuario);
            
            request.setAttribute("usuario",usuario);
            request.setAttribute("comentarios",comentarios);
            request.setAttribute("remedio",remedio);
            request.getRequestDispatcher("remedio.jsp").forward(request, response); 
            
        } catch (XolerDAOException ex) {
            Logger.getLogger(remedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

                
    }

   

}
