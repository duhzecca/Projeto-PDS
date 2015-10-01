package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.BEANUsuario;

public final class comprafinalizada_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/recuperaSession.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html lang=\"en-US\" xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\">\n");
      out.write("    <head>\n");
      out.write("        <title>Drogaria.Me</title>\n");
      out.write("        <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"css/images/favicon.ico\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.6.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.jcarousel.min.js\"></script>\n");
      out.write("        <!--[if IE 6]>\n");
      out.write("                <script type=\"text/javascript\" src=\"js/png-fix.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/functions.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");

  //recupera session
  HttpSession s = request.getSession(false);
  BEANUsuario user = null;
  boolean logado = false;
  if (null != s && (BEANUsuario) s.getAttribute("Usuario") != null) {
    logado = true;
    user = (BEANUsuario) s.getAttribute("Usuario");
  }

      out.write("\n");
      out.write("        <!-- Header -->\n");
      out.write("            <div id=\"header\" class=\"shell\">\n");
      out.write("            <div id=\"logo\"><h1><a href=\"/projetopds/index.jsp\">Drogaria.Me</a></h1><span>Seu Mercado Livre de Remédios!</span></div>\n");
      out.write("            <!-- Navigation --\n");
      out.write("            <div id=\"navigation\" >\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- End Navigation -->\n");
      out.write("            <div class=\"cl\">&nbsp;</div>\n");
      out.write("            \n");
      out.write("            <!-- Login-details -->\n");
      out.write("            \n");
      out.write("                ");
 if (logado) {
                
      out.write("\n");
      out.write("                <div id=\"login-details2\">\n");
      out.write("                <!-- User is logged, its name displays on the login details div -->\n");
      out.write("                 \n");
      out.write("                    <form method=\"get\" action=\"ValidaLogin\" style=\"text-align: right; margin-top: -20px;\" >\n");
      out.write("                        <p><a href=\"#\" onclick=\"\" class=\"userName\" style=\"padding-right: 20px;\">Olá, ");
      out.print(user.getNome());
      out.write("!</a>\n");
      out.write("                        <input class=\"but\" type=\"submit\" value=\"Sair\" onclick=\"ValidaLogin\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"acao\" value=\"logout\"/>\n");
      out.write("                    </form>\n");
      out.write("                </p>\n");
      out.write("                ");
} else { //se nao esta logado
                
      out.write("\n");
      out.write("              <div id=\"login-details\">\n");
      out.write("                <!-- User is not logged, it can log in or sign in on the website -->    \n");
      out.write("                <h4><center>Já possui uma conta?</center></h4>\n");
      out.write("                <form method=\"post\" onsubmit=\"return VerificaEmail(document.getElementById('usuarioLogin').value)\" action=\"ValidaLogin\" >\n");
      out.write("                    <input type=\"text\" name=\"usuarioLogin\" id=\"usuarioLogin\" class=\"field\" style=\"color:#8A8A8A; font-size: 14px\" title=\"Your Name\" />\n");
      out.write("                    <input type=\"password\" name=\"senhaLogin\" class=\"field\" style=\"color:#8A8A8A; font-size: 14px;\" title=\"Email\" />\n");
      out.write("                    <div class=\"form-buttons\" style=\"margin-left: 20%\">\n");
      out.write("                        <input type=\"submit\" id=\"entrar\" value=\"Login!\" class=\"submit-btn\" style=\"font-size: 14px\"/>\n");
      out.write("                        <a href=\"esqueceuSenha.jsp\" style=\"padding-left: 15%;\">Esqueci minha senha</a>\n");
      out.write("                    </div>\n");
      out.write("                    <center></center>\n");
      out.write("                    <input type=\"hidden\" name=\"acao\" id=\"acao\" value=\"login\" />\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"login-details1\" >\n");
      out.write("                <h4><br /><a href=\"/projetopds/cadastro.jsp\">ou Cadastre-se aqui!</a></h4>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <!-- End Login-details -->\n");
      out.write("        </div>\n");
      out.write("        <!-- End Header -->\n");
      out.write("        <!-- Main -->\n");
      out.write("            ");
 if (logado) {
            
      out.write("\n");
      out.write("            <div id=\"main\" class=\"shell\">\n");
      out.write("                <!-- Sidebar -->\n");
      out.write("                <div id=\"sidebar\">\n");
      out.write("                    <ul class=\"categories\">\n");
      out.write("                        <li>\n");
      out.write("                            <h4>Sua página! :)</h4>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"/projetopds/cadastroRemedio.jsp\">+ Cadastrar Produto</a></li>\n");
      out.write("                                <li><a href=\"/projetopds/seusprodutos.jsp\">+ Seus Produtos</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                ");
} else { //se nao esta logado
                
      out.write("\n");
      out.write("                <div id=\"mainzin\" class=\"shell\">\n");
      out.write("                    <div id=\"sidebar\">\n");
      out.write("                        <ul class=\"categories\">\n");
      out.write("                            <li>\n");
      out.write("                                <h4 style=\"text-align: center\">Cadastre-se já!</h4>\n");
      out.write("                                <ul>\n");
      out.write("                                    <p style=\"color: black; text-align: center\">\n");
      out.write("                                    Ao se cadastrar, você poderá adicionar novos remédios para doação/venda, fazer comentários\n");
      out.write("                                    em remédios anunciados, ter a lista dos seus produtos cadastrados, comprar remédios e muito mais!\n");
      out.write("                                    <br/>Oque está esperando para se cadastrar?\n");
      out.write("                                    </p>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                <!-- End Sidebar -->\n");
      out.write("                <!-- Search Bar -->\n");
      out.write("                <div id=\"search\" style=\"height:70px; width: 100%; margin: 0 auto;\">\n");
      out.write("                    <form action=\"AcaoRemedio\" class='right' id='searchthis' method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"buscar\" id=\"acao\" name=\"acao\"/>\n");
      out.write("                        <input class=\"input-text\" id=\"searchBox\" name=\"searchBox\" onblur=\"if(this.value==&quot;&quot;)this.value=this.defaultValue;\" onfocus=\"if(this.value==this.defaultValue)this.value=&quot;&quot;;\" type=\"text\" value=\"Pesquisar...\" vinput=\"\" />\n");
      out.write("                        <input class=\"searchbutton\" id=\"submit-button\" type=\"submit\" value=\"Go\"  />\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!-- End Search Bar -->\n");
      out.write("                <!-- Content -->\n");
      out.write("                <div id=\"content\">\n");
      out.write("                    <!-- Products -->\n");
      out.write("                    <div class=\"products\">\n");
      out.write("                        <h3>MUITO OBRIGADO POR COMPRAR COM A DROGARIA.ME! </h3>\n");
      out.write("                        <p>Em breve você receberá um email da nosso time.</p>\n");
      out.write("                        <p>Por favor, qualquer dúvida ou problemas entre em contato conosco:</p>\n");
      out.write("                        <p>Email: andrermitsuoka@gmail.com.</p>\n");
      out.write("                        <p>Ou pelo SAC 24 horas (ligue a hora que quiser): (15)99766-0494</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cl\">&nbsp;</div>\n");
      out.write("                </div>\n");
      out.write("                <!-- End Content -->\n");
      out.write("                <!-- End Content -->\n");
      out.write("                <div class=\"cl\">&nbsp;</div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- End Main -->\n");
      out.write("            <!-- Footer -->\n");
      out.write("            ");
 if (logado) {
            
      out.write("\n");
      out.write("            <div id=\"footer1\" class=\"shell\">\n");
      out.write("                ");
} else { //se nao esta logado
                
      out.write("\n");
      out.write("                <div id=\"footer\" class=\"shell\">  \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    <div class=\"top\">\n");
      out.write("                        <div class=\"cnt\">\n");
      out.write("                            <div class=\"col about\">\n");
      out.write("                                <h4>Sobre Nós!</h4>\n");
      out.write("                                <p>CardBoardBox Software!</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col store\">\n");
      out.write("                                <h4>Acesso Rápido</h4>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li><a href=\"/projetopds/termoderesponsa.jsp\">Termos e Condições</a></li>\n");
      out.write("                                    <li><a href=\"/projetopds/sobre.jsp\">Sobre</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cl\">&nbsp;</div>\n");
      out.write("                            <div class=\"copy\">\n");
      out.write("                                <p>&copy; <a href=\"/projetopds/index.jsp\">Drogaria.Me</a>. Design by <a href=\"http://pdsufscar.appspot.com/\" target=\"_blank\">CardBoardBox Software.</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>            \n");
      out.write("                </div>\n");
      out.write("                <!-- End Footer -->\n");
      out.write("                </body>\n");
      out.write("                </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
