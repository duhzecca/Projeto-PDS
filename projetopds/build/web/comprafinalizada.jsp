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
                    <form action="AcaoRemedio" class='right' id='searchthis' method="post">
                        <input type="hidden" value="buscar" id="acao" name="acao"/>
                        <input class="input-text" id="searchBox" name="searchBox" onblur="if(this.value==&quot;&quot;)this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value=&quot;&quot;;" type="text" value="Pesquisar..." vinput="" />
                        <input class="searchbutton" id="submit-button" type="submit" value="Go"  />
                    </form>
                </div>
                <!-- End Search Bar -->
                <!-- Content -->
                <div id="content">
                    <!-- Products -->
                    <div class="products">
                        <h3>MUITO OBRIGADO POR COMPRAR COM A DROGARIA.ME! </h3>
                        <p>Em breve você receberá um email da nosso time.</p>
                        <p>Por favor, qualquer dúvida ou problemas entre em contato conosco:</p>
                        <p>Email: andrermitsuoka@gmail.com.</p>
                        <p>Ou pelo SAC 24 horas (ligue a hora que quiser): (15)99766-0494</p>
                    </div>
                    <div class="cl">&nbsp;</div>
                </div>
                <!-- End Content -->
                <!-- End Content -->
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
                                <p>&copy; <a href="/projetopds/index.jsp">Drogaria.Me</a>. Design by <a href="http://pdsufscar.appspot.com/" target="_blank">CardBoardBox Software.</a></p>
                            </div>
                        </div>
                    </div>            
                </div>
                <!-- End Footer -->
                </body>
                </html>