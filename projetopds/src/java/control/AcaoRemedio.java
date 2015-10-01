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
import model.*;
import model.XolerDAOException;

/**
 *
 * @author Mitsuoka
 */
public class AcaoRemedio extends HttpServlet {

    private String busca;

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

        if (acao.compareTo("listaTopRemedio") == 0) {
            try {
                acaoListaTopRemedio(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } if (acao.compareTo("listaTopRemedio1") == 0) {
            try {
                acaoListaTopRemedio1(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("buscar") == 0) {
            try {
                acaoBuscar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("filtrar") == 0) {
            try {
                acaoFiltrar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("fBusca") == 0) {
            try {
                acaoFiltrarBusca(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("excluir") == 0) {           
            try {
                acaoDeletar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("alterar") == 0) {

        }
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
        } else if (acao.compareTo("buscar") == 0) {
            try {
                acaoBuscar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("filtrar") == 0) {
            try {
                acaoFiltrar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("excluir") == 0) {           
            try {
                acaoDeletar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("ativar") == 0) {
            try {
                acaoAtivar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("inativar") == 0) {
            try {
                acaoInativar(request, response);
            } catch (XolerDAOException ex) {
                Logger.getLogger(AcaoRemedio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void acaoAdicionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String nome = request.getParameter("nome_remedio");
        String descricao = request.getParameter("descricao");
        String validade = request.getParameter("validade");
        String string_preco = request.getParameter("preco");
        float preco;
        preco = Float.parseFloat(string_preco);
        String foto = request.getParameter("foto");

        String tipo = request.getParameter("tipo_unidade");
        int quantidade_tipo = Integer.parseInt(request.getParameter("quantidade_tipo"));
        int dose = Integer.parseInt(request.getParameter("dose"));

        //pega o tipo do remedio
        String tipoRemedio = request.getParameter("tipoRemedio");

        //variaveis para o anuncio
        String email = request.getParameter("email");
        Date d = new Date();
        d = new Timestamp(d.getTime());

        boolean logado = true;
        boolean erro = false;
        int id;
        int id_remedio;

        //adiciona a UNIDADE DE MEDIDA
        try {
            DAOUnidadeMedida um = new DAOUnidadeMedida(logado);
            id = um.adiciona(tipo, quantidade_tipo, dose);
            //ADICIONA O REMÉDIO
            DAORemedio remedio = new DAORemedio(logado);
            id_remedio = remedio.adiciona(nome, descricao, validade, preco, foto, id, tipoRemedio);
            //ADICIONA O ANUNCIO
            DAOAnuncio anuncio = new DAOAnuncio(logado);
            anuncio.adiciona(email, id_remedio, d);
        } catch (XolerDAOException sqle) {
            erro = true;
        }

        RequestDispatcher rd = null;
        if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro durante o cadastro. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/cadastro.jsp");
        } else {
            request.setAttribute("msgCadastro", "Cadastro efetuado com sucesso!");
            rd = request.getRequestDispatcher("/index.jsp");
        }

        response.sendRedirect("index.jsp");
    }

    private void acaoBuscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        boolean logado = true;

        List<BeanRemedio> list = null;
        try {
            DAORemedio remedios = new DAORemedio(logado);

            int page = 1;
            int recordsPerPage = 12;
            int preco = 1000000;

            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            if (request.getParameter("valor") != null) {
                String string = request.getParameter("valor");
                preco = Integer.parseInt(string);
            }

            String generico = "todos";

            if (request.getParameter("generico") == null) {
                generico = "todos";
            } else {
                generico = request.getParameter("generico");
            }

            String searchField = "";

            searchField = (String) request.getParameter("searchBox");

            if (searchField.equals("Pesquisar...")) {
                searchField = request.getParameter("oldSearch");
                if (searchField == null) {
                    searchField = "";
                }
            }

            try {
                DAORemedio rem = new DAORemedio(logado);

                list = rem.filtraBuscaPreco(searchField, preco, generico);

                //request.setAttribute("listaRemedios", list);
            } catch (XolerDAOException sqle) {
                request.setAttribute("listaRemedios", null);
            }

            //chama a funcao consultaNome no DAORemedio
            //list = remedios.consultaNome(searchField);
            int size = list.size();
            int n_of_pages = (int) Math.ceil(size * 1.0 / recordsPerPage);

            //seta a lista no view do resultado da busca
            request.setAttribute("listaRemedios", list);

            Integer intObj = new Integer(n_of_pages);
            Integer intObj2 = new Integer(page);
            Integer valor = new Integer(preco);
            String s = new String(searchField);

            request.setAttribute("generico", generico);
            request.setAttribute("preco", valor);
            request.setAttribute("search", s);
            request.setAttribute("n_of_pages", intObj);
            request.setAttribute("page", intObj2);

        } catch (XolerDAOException sqle) {
            request.setAttribute("listaRemedios", null);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/resultadoBusca.jsp");
        rd.forward(request, response);
    }

    private void acaoFiltrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String string;
        string = request.getParameter("valor");

        int preco = Integer.parseInt(string);
        boolean logado = true;

        List<BeanRemedio> list = null;

        try {
            DAORemedio remedios = new DAORemedio(logado);

            list = remedios.consultaPreco(preco);

            request.setAttribute("listaRemedios", list);

        } catch (XolerDAOException sqle) {
            request.setAttribute("listaRemedios", null);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/resultadoBusca.jsp");

        rd.forward(request, response);

    }

    private void acaoFiltrarBusca(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

        String string;
        string = request.getParameter("valor");

        int preco = Integer.parseInt(string);
        boolean logado = true;

        List<BeanRemedio> list = null;

        try {
            DAORemedio remedios = new DAORemedio(logado);
            String tipo = "todos";
            list = remedios.filtraBuscaPreco(busca, preco, tipo);

            request.setAttribute("listaRemedios", list);

        } catch (XolerDAOException sqle) {
            request.setAttribute("listaRemedios", null);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/resultadoBusca.jsp");

        rd.forward(request, response);

    }

    private void acaoListaTopRemedio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        List<BeanRemedio> listaDeRemedios;
        String paginaOrigem = request.getParameter("paginaOrigem");

        try {
            DAORemedio remedios = new DAORemedio(true);
            listaDeRemedios = remedios.listaTopRemedios();
            request.setAttribute("listaTopRemedio", listaDeRemedios);
        } catch (Exception sqle) {
            listaDeRemedios = new ArrayList<BeanRemedio>();
            request.setAttribute("listaTopRemedio", listaDeRemedios);
        }
        RequestDispatcher rd = null;
        if (paginaOrigem.equals("index")) {
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            rd = request.getRequestDispatcher("/index.jsp");
        }

        rd.forward(request, response);
    }
    
    private void acaoListaTopRemedio1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        List<BeanRemedio> listaDeRemedios;
        String paginaOrigem = request.getParameter("paginaOrigem");

        try {
            DAORemedio remedios = new DAORemedio(true);
            listaDeRemedios = remedios.listaTopRemedios1();
            request.setAttribute("listaTopRemedio1", listaDeRemedios);
        } catch (Exception sqle) {
            listaDeRemedios = new ArrayList<BeanRemedio>();
            request.setAttribute("listaTopRemedio1", listaDeRemedios);
        }
        RequestDispatcher rd = null;
        if (paginaOrigem.equals("index")) {
            rd = request.getRequestDispatcher("/index.jsp");
        } else {
            rd = request.getRequestDispatcher("/index.jsp");
        }

        rd.forward(request, response);
    }

    private void acaoDeletar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {        
        String id = request.getParameter("id");        
        int id_remedio = Integer.parseInt(id);        
        
        boolean logado = true;
        boolean erro = false;

        try {
            DAOAnuncio anuncio = new DAOAnuncio(logado);
            anuncio.remove(id_remedio);
            DAORemedio remedio = new DAORemedio(logado);
            remedio.remove(id_remedio);
        } catch (XolerDAOException sqle) {
            erro = true;
        }

        RequestDispatcher rd = null;
        if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro durante a remocao. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        } else {
            request.setAttribute("msgCadastro", "Produto removido com sucesso!");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        }

        response.sendRedirect("seusprodutos.jsp");

    }

    private void acaoAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {

    }
    
    private void acaoAtivar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        String id = request.getParameter("id");
        int id_remedio = Integer.parseInt(id);

        boolean logado = true;
        boolean erro = false;

        try {
            DAORemedio remedio = new DAORemedio(logado);
            remedio.ativa(id_remedio);
        } catch (XolerDAOException sqle) {
            erro = true;
        }

        RequestDispatcher rd = null;
        if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro durante o processo. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        } else {
            request.setAttribute("msgCadastro", "Produto Ativo!");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        }

        response.sendRedirect("seusprodutos.jsp");
    }

    private void acaoInativar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, XolerDAOException {
        String id = request.getParameter("id");
        int id_remedio = Integer.parseInt(id);

        boolean logado = true;
        boolean erro = false;

        try {
            DAORemedio remedio = new DAORemedio(logado);
            remedio.inativa(id_remedio);            
        } catch (XolerDAOException sqle) {
            erro = true;
        }

        RequestDispatcher rd = null;
        if (erro) {
            request.setAttribute("msgCadastro", "Ocorreu um erro durante o processo. Tente novamente mais tarde.");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        } else {
            request.setAttribute("msgCadastro", "Produto Inativo!");
            rd = request.getRequestDispatcher("/seusprodutos.jsp");
        }

        response.sendRedirect("seusprodutos.jsp");
    }
}
