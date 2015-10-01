<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@page import="model.BeanRemedio"%>
<%@page import="model.BeanComentario"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
    <head>
        <title>Drogaria.Me</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="css/images/favicon.ico" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
        <!--[if IE 6]>
                <script type="text/javascript" src="js/png-fix.js"></script>
        <![endif]-->
        <script type="text/javascript" src="js/functions.js"></script>
        <!--IMPORT AUTO COMPLETE SEARCH-->
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 
        <script src="autocompleter.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css"></link>
        <!--IMPORT AUTO COMPLETE SEARCH-->
    </head>
    <body>
        <%@include file="recuperaSession.jsp"%>
        <!-- Header -->
        <div id="header" class="shell">
            <div id="logo"><h1><a href="/projetopds/index.jsp">Drogaria.Me</a></h1><span>Seu Mercado Livre de Remédios!</span></div>
            <!-- Navigation --
            <div id="navigation" >

            </div>
            <!-- End Navigation -->
            <div class="cl">&nbsp;</div>
            
            <!-- Login-details -->
            
                <% if (logado) {
                %>
                <div id="login-details2">
                <!-- User is logged, its name displays on the login details div -->
                 
                    <form method="get" action="ValidaLogin" style="text-align: right; margin-top: -20px;" >
                        <p><a href="#" onclick="" class="userName" style="padding-right: 20px;">Olá, <%=user.getNome()%>!</a>
                        <input class="but" type="submit" value="Sair" onclick="ValidaLogin"/>
                        <input type="hidden" name="acao" value="logout"/>
                    </form>
                </p>
                <%} else { //se nao esta logado
                %>
              <div id="login-details">
                <!-- User is not logged, it can log in or sign in on the website -->    
                <h4><center>Já possui uma conta?</center></h4>
                <form method="post" onsubmit="return VerificaEmail(document.getElementById('usuarioLogin').value)" action="ValidaLogin" >
                    <input type="text" name="usuarioLogin" id="usuarioLogin" class="field" style="color:#8A8A8A; font-size: 14px" title="Your Name" />
                    <input type="password" name="senhaLogin" class="field" style="color:#8A8A8A; font-size: 14px;" title="Email" />
                    <div class="form-buttons" style="margin-left: 20%">
                        <input type="submit" id="entrar" value="Login!" class="submit-btn" style="font-size: 14px"/>
                        <a href="esqueceuSenha.jsp" style="padding-left: 15%;">Esqueci minha senha</a>
                    </div>
                    <center></center>
                    <input type="hidden" name="acao" id="acao" value="login" />

                </form>
            </div>

            <div id="login-details1" >
                <h4><br /><a href="/projetopds/cadastro.jsp">ou Cadastre-se aqui!</a></h4>
            </div>

            <%}%>
            
            
            <!-- End Login-details -->
        </div>
        <!-- End Header -->
        <!-- Main -->
        <% if (logado) {
        %>
        <div id="main" class="shell">
            <!-- Sidebar -->
            <div id="sidebar">
                <ul class="categories">
                    <li>
                        <h4>Sua página! :)</h4>
                        <ul>
                            <li><a href="/projetopds/cadastroRemedio.jsp">+ Cadastrar Produto</a></li>
                            <li><a href="/projetopds/seusprodutos.jsp">+ Seus Produtos</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <%} else { //se nao esta logado
            %>
            <div id="mainzin" class="shell">
            <div id="sidebar">
                <ul class="categories">
                    <li>
                        <h4 style="text-align: center">Cadastre-se já!</h4>
                        <ul>
                            <p style="color: black; text-align: center">
                            Ao se cadastrar, você poderá adicionar novos remédios para doação/venda, fazer comentários
                            em remédios anunciados, ter a lista dos seus produtos cadastrados, comprar remédios e muito mais!
                            <br/>Oque está esperando para se cadastrar?
                            </p>
                        </ul>
                    </li>
                </ul>
            </div>

                <%}%>
                <!-- End Sidebar -->
                <!-- Search Bar -->
                <div id="search" style="height:70px; width: 100%; margin: 0 auto;">
                    <form action="AcaoRemedio" class='right' id='searchthis' method="get">
                        <input type="hidden" value="buscar" id="acao" name="acao"/>
                        <input class="input-text" id="searchBox" name="searchBox" type="text" onFocus="javascript:if(this.value == 'Pesquisar...') { this.value=''; }" value="Pesquisar..."/>
                        <input class="searchbutton" id="submit-button" type="submit" value="Go"  />
                    </form>
                </div>
                <br />
                <!-- End Search Bar -->
               <!-- Content -->
               <% BeanRemedio r = (BeanRemedio)request.getAttribute("remedio");
                  BEANUsuario usuario_dono = (BEANUsuario)request.getAttribute("usuario");
               %>               
               <%if ((r == null) ){ %>
               <h1>Remédio Não Encontrado!</h1>
               <%}else{%>
               <%}%>
                <div id="content">
                    <div id="especificao">
                        <div id="foto" style="">
                             <span class="holder">
                                 <a href="javascript:void(0);" onclick=""><img style="float: left; margin-right: 50px;  max-width: 200px; min-width: 200px; min-height: 300px; max-height: 300px;" src="<%= r.getFoto()%>" alt="Img" /></a><p></p>
                                 <br><br>
                             </span>
                        </div>
                        <div id="detalhes" style="">
                            <p style="font-weight: bold; font-size: 24px; "> <%= r.getNome() %></p>
                            </br>
                            <p>Anunciada pelo usuário: <a href="#"><%=usuario_dono.getNome()%></a></p>
                            <p><%= r.getDescricao() %><br /></p>                           
                            <p><b>Validade:</b> <%=r.getValidade()%></p>
                            <br>
                            <p style="font-size: 20px;">Preço: R$ <b><%= r.getPreco() %></b></p>
                            <br>
                               <!-- <p align="right" class="but"><a style="color: white"> COMPRAR AGORA!</a></p>    -->
                                <br></br>
                                 <% if (logado) { 
                                 %>
                                <!-- INICIO FORMULARIO BOTAO PAGSEGURO -->
                                <form action="https://ws.pagseguro.uol.com.br/v2/checkout/
                                        email=xdalyson@gmail.com
                                        &token=34B47692D53440BF9ABDDEF296D9B9B4\
                                        &currency=BRL\
                                        &itemId1=0001\
                                        &itemDescription1=Notebook Prata\
                                        &itemAmount1=100000" 
                                        method="post" onsubmit="PagSeguroLightbox(this); return false;">
                                <!-- NÃO EDITE OS COMANDOS DAS LINHAS ABAIXO -->
                                <input type="hidden" name="code" value="8F6611F9DDDD109FF41E0FB8A2188AFF" />
                                <input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/pagamentos/120x53-comprar.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
                                </form>
                                <script type="text/javascript" src="https://stc.pagseguro.uol.com.br/pagseguro/api/v2/checkout/pagseguro.lightbox.js"></script>
                                <!-- FINAL FORMULARIO BOTAO PAGSEGURO -->
                                <%} else { //se nao esta logado
                                %>
                                <h4>Você precisa estar logado para comprar.</h4>
                                <%}%>
                            <p></p>
                        </div>    
                    </div>
                            <br><br><br><br><br>
                    <div id="classificacao">
                        <h3>Classificação do Vendedor</h3>
                        <% if (logado) { %>
                        <h5>Classifique este vendedor, sua participação é o que nos ajuda! </h5>
                        <p> (0 é insuficiente e 5 é confiável) </p>
                          <form id="avaliaUsuario" method="post" action="AcaoUsuario">
                            <input type="hidden" name="acao" id="acao" value="avaliar"/>
                            <input type="hidden" name="dono" id="dono" value="<%=usuario_dono.getEmail()%>"/>
                            Selecione uma nota: <select name="notaUsuario" id="notaUsuario" onchange="VerificaNota(document.getElementById('notaUsuario').value)"
                                    <option value="">Selecione a nota</option>
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                            </select>
                            <input class="but" type="submit" value="Avaliar">
                        </form>
                        <%} else { //se nao esta logado
                        %>
                        <h4>Você precisa estar logado para avaliar um usuário.</h4>
                        <%}%>
                        <br><br>
                                <% if (usuario_dono.getClassificacao() >= 0 && usuario_dono.getClassificacao() < 1.0 ) {%>
                                    <div style="border:10px solid red; padding: 25px; background-color: #EE6363">
                                        <p style="font-size: 24px; color: white;"><b>Vendedor Desabilitado</b></p>
                                        <p style="font-size: 16px; color: white;">ATENÇÃO!!! Não recomendamos nenhuma negociação com este vendedor.</p>
                                   </div>
                                <%}%>
                                <% if (usuario_dono.getClassificacao() >= 1.0 && usuario_dono.getClassificacao() < 2.0 ) {%>
                                    <div style="border:10px solid orange; padding: 25px; background-color: coral">
                                        <p style="font-size: 24px; color: white;"><b>Vendedor Duvidoso</b></p>
                                        <p style="font-size: 16px; color: white;">Recomendamos cuidado ao negociar com este vendedor.</p>
                                   </div>
                                <%}%>
                                <% if (usuario_dono.getClassificacao() >= 2.0 && usuario_dono.getClassificacao() < 3.0 ) {%>
                                    <div style="border:10px solid yellow; padding: 25px; background-color: #FFFF99">
                                        <p style="font-size: 24px; color: black;"><b>Vendedor Médio</b></p>
                                        <p style="font-size: 16px; color: black;">Recomendamos perguntar todas as dúvidas antes de comprar. 
                                        <br>Pesquise suas outras transações antes.</p>
                                   </div>
                                <%}%>
                                <% if (usuario_dono.getClassificacao() >= 3.0 && usuario_dono.getClassificacao() < 4.0 ) {%>
                                    <div style="border:10px solid green; padding: 25px; background-color: greenyellow">
                                        <p style="font-size: 24px; color: black;"><b>Vendedor em Destaque</b></p>
                                        <p style="font-size: 16px; color: black;">Nós recomendamos este vendedor por suas transações anteriores.</p>
                                   </div>
                                <%}%>
                                <% if (usuario_dono.getClassificacao() >= 4.0 && usuario_dono.getClassificacao() <= 5.0 ) {%>
                                <div style="border:10px solid gray; padding: 15px; background-color: lightgrey">
                                    <img style="float: left; width: 120px;" src="css/images/gold.png" alt="Img" />
                                    <br>
                                    <p style="font-size: 24px; color: black;"><b>Vendedor Master da Drogaria.Me </b></p>
                                    <p style="font-size: 16px; color: black;">É um vendedor premium, a melhor classificação do site.
                                    <br>Nós indicamos esse vendedor por ser nosso colaborador!</p>
                                </div>
                                <%}%>
                        </br></br>
                    </div>
                    <div id="comentarios">
                        <%
                                        List<BeanComentario> listaComentario = null;
                                        if (request.getAttribute("comentarios") != null) {
                                            listaComentario = (List<BeanComentario>) request.getAttribute("comentarios");
                                        }
 
                        %>   
                        <h3>Comentários  (<%= listaComentario.size()  %>)  </h3>
                        <%if(logado){%>
                        <form method="post" action="AcaoComentario">
                            <textarea type="text"  style="background-color:#9FE073;width:300px;height:100px;"  name="comentario" id="comentario"> </textarea>
                        <input style="visibility: hidden;"name="id_remedio" value="<%=r.getId_remedio()%>"></input>
                        <input style="visibility: hidden;"name="acao" value="adicionar"></input>
                        <input style="visibility: hidden;"name="email" value="<%=user.getEmail()%>"/>

                        <input class="but" type="submit" value="Enviar" style="float: left"></input>
                        <br><br><br>
                        </form>
                        <%}else{%>
                        <h4>Você deve estar logado para comentar</h4>
                        <%}%>
                        <%                                       
                                        //Se não for vazio exibe o html de comentário
                                        if ( listaComentario.size() == 0) {
                                            %><%
                                        }else{
                                            for (Iterator i = listaComentario.iterator(); i.hasNext();) {
                                                BeanComentario l = (BeanComentario) i.next();
                        %>
                        </br><div style="border: 0px solid ; background: #EAEAEA">
                        <h4>Comentário feito por <%= l.getNome()%>, em <%= l.getData()%>: </h4>
                        <h5><%= l.getDescricao()%> </h5>
                        <h4> </h4>
                        </div>
                        <%
                                            }//fim for
                                        }//fim se
                        %>
                    </div>
                </div>
                <!-- End Content--> 
                <div class="cl">&nbsp;</div>
            </div>
            <!-- End Main -->
            <!-- Footer -->
            <% if (logado) {
            %>
            <div id="footer1" class="shell">
                <%} else { //se nao esta logado
                %>
                <div id="footer" class="shell">  
                    <%}%>
                    <div class="top">
                        <div class="cnt">
                            <div class="col about">
                                <h4>Sobre Nós!</h4>
                                <p>CardBoardBox Software!</p>
                            </div>
                            <div class="col store">
                                <h4>Acesso Rápido</h4>
                                <ul>
                                    <li><a href="/projetopds/termoderesponsa.jsp">Termos e Condições</a></li>
                                    <li><a href="/projetopds/sobre.jsp">Sobre</a></li>
                                </ul>
                            </div>
                            <div class="cl">&nbsp;</div>
                            <div class="copy">
                                <p>&copy; <a href="#">Drogaria.Me</a>. Design by <a href="http://pdsufscar.appspot.com/">CardBoardBox Software.</a></p>
                            </div>
                        </div>
                    </div>            
                </div>
                <!-- End Footer -->
                </body>
                </html>