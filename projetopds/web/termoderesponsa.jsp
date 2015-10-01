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
            <div id="logo"><h1><a href="/projetopds/index.jsp">Drogaria.Me</a></h1><span>Seu Mercado Livre de Rem�dios!</span></div>
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
                        <p><a href="#" onclick="" class="userName" style="padding-right: 20px;">Ol�, <%=user.getNome()%>!</a>
                        <input class="but" type="submit" value="Sair" onclick="ValidaLogin"/>
                        <input type="hidden" name="acao" value="logout"/>
                    </form>
                </p>
                <%} else { //se nao esta logado
                %>
              <div id="login-details">
                <!-- User is not logged, it can log in or sign in on the website -->    
                <h4><center>J� possui uma conta?</center></h4>
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
                            <h4>Sua p�gina! :)</h4>
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
                                <h4 style="text-align: center">Cadastre-se j�!</h4>
                                <ul>
                                    <p style="color: black; text-align: center">
                                    Ao se cadastrar, voc� poder� adicionar novos rem�dios para doa��o/venda, fazer coment�rios
                                    em rem�dios anunciados, ter a lista dos seus produtos cadastrados, comprar rem�dios e muito mais!
                                    <br/>Oque est� esperando para se cadastrar?
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
                        <h3>Ajuda e Termo de Compromisso</h3>
                        <p><b>1. Objeto</b></br>
                        Os servi�os do presente objeto consiste em oferecer e hospedar espa�os no sistema para que os 
                        usu�rios vendedores/doadores possam anunciar seus produtos e compradores/receptores possam solicitar
                        ou comprar os produtos ofertados por meio da divulga��o dos contatos destes atores da transa��o.
                        A Drogaria.Me possibilita, portanto, o contato e a negocia��o diretos entre vendedor/doador e 
                        comprador/receptor sem qualquer interven��o, na negocia��o ou concretiza��o da transa��o.
                        � importante ressaltar que a Drogaria.Me n�o fornece qualquer produto ou servi�o anunciado em seu site.
                               </p></br>
                        <p><b>2. Capacidade de cadastro</b></p>
                        <p>O sistema Drogaria.Me estar� dispon�vel somente para pessoas f�sicas e jur�dicas com 
                            capacidade legal e que n�o tenha sido exclu�da do sistema definitivamente ou temporariamente.
                        O usu�rio dever� se comprometer em n�o fornecer seus dados de acesso a terceiros.
                        </p></br>
                        <p><b>3. Cadastro</b></p>
                        <p>A confirma��o do cadastro de usu�rio s� se dar� ap�s o preenchimento de todos os campos obrigat�rios 
                            do formul�rio de cadastro com informa��es verdadeiras e precisas. E caso n�o sejam a Drogaria.Me 
                            ter� total direito em excluir temporariamente ou definitivamente o usu�rio, sem preju�zo de qualquer 
                        outra medida.</p></br>
                        <p><b>4. Produtos anunciados</b></p>
                        <p>O usu�rio poder� anunciar seu produto de acordo com as categorias e subcategorias existentes no 
                            sistema. Os an�ncios poder� possuir fotos, textos, descri��es e outras informa��es relevantes, 
                            desde que n�o viole nenhumas das leis em vigor, para a clara identifica��o do produto.
                        </p></br>
                        <p><b>5. Privacidade da Informa��o</b></p>
                        <p>Todos os dados do sistema, com exce��o das informa��es p�blicas, aquelas necess�rias para a 
                            consolida��o das transa��es, ser�o armazenados em servidores seguros. Todas as medidas poss�veis
                            para o bom funcionamento do sistema e necess�rias para a seguran�a e sigilo dos dados ser�o tomadas
                            periodicamente.
                        </p></br>
                        <p><b>6. Obriga��es dos Usu�rios</b></p>
                        <p>A manifesta��o de interesse do usu�rio comprador deve ser realizada durante o prazo de vig�ncia do an�ncio ou at� o esgotamento do estoque.
                        O comprador ter� a responsabilidade de efetuar o pagamento do produto, de acordo com as exig�ncias do an�ncio, bem como as taxas referentes a entrega dentro do prazo de vencimento.
                        O vendedor ter� a responsabilidade de, ap�s receber o pagamento, providenciar a entrega do produto de forma acordada e dentro da data estipulada
                        A Drogaria.Me n�o se responsabiliza pelas obriga��es tribut�rias sobre as atividades dos usu�rios do site.
                        </p></br>
                        <p><b>7. Pr�ticas vedadas</b></p>
                        <p>Os usu�rios n�o poder�o interferir em negocia��es de outros usu�rios, nem divulgar informa��es n�o p�blicas. Atitudes estas pass�veis de cancelamento parcial ou definitivo do sistema.
                        </p></br>
                        <p><b>8. Viola��o no sistema ou da base de dados</b></p>
                        <p>N�o � permitida a utiliza��o de qualquer tipo de equipamento tecnol�gico, bem como software, sistema ou meio a fim de acessar o banco de dados do sistema.
                        </p></br>
                        <p><b>9. San��es</b></p>
                        <p>A Drogaria.Me tem o total direito de solicitar qualquer documento ou acessar qualquer dado de seus usu�rios.
                        </p></br>
                        <p><b>10. Responsabilidades</b></p>
                        <p>A Drogaria.Me n�o se responsabiliza pela veracidade dos dados e informa��es disponibilizadas por seus usu�rios, bem como pela qualidade, estado, integridade ou legitimidade dos produtos oferecidos ou adquiridos pelo sistema.
                        </p></br>
                        <p><b>11. Falhas no sistema</b></p>
                        <p>A Drogaria.Me n�o se responsabiliza por qualquer preju�zo, perda ou dano sofridos pelo usu�rio em raz�o de falhas na internet, sistema ou servidor utilizado pelo usu�rio.
                        </p></br>
                        <p><b>12. Tarifas e faturamento</b></p>
                        <p>O cadastro no sistema Drogaria.Me � gratuito. Ao comercializar um produto no Drogaria.Me, o site receber� um percentual da venda. Este percentual � informado no momento de cadastro de um produto para venda via Drogaria.Me.
                        </p></br>
                        <p><b>13. Sistema de reputa��o</b></p>
                        <p>O usu�rio da plataforma Drogaria.Me possui a seu dispor um sistema de qualifica��o, que permite que os compradores avaliem suas transa��es, bem como o vendedor de fornecer um feedback em rela��o as solicita��es que � uma excelente ferramenta para que o comprador analise seu vendedor antes mesmo de efetuar a transa��o.
                        � importante ressaltar que todas as informa��es postadas no sistema de qualifica��o � de inteira responsabilidade de seus usu�rios.
                        </p></br>
                        <!-- End Products -->
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
                                <h4>Sobre N�s!</h4>
                                <p>CardBoardBox Software!</p>
                            </div>
                            <div class="col store">
                                <h4>Acesso R�pido</h4>
                                <ul>
                                    <li><a href="/projetopds/termoderesponsa.jsp">Termos e Condi��es</a></li>
                                    <li><a href="/projetopds/sobre.jsp">Sobre</a></li>
                                </ul>
                            </div>
                            <div class="cl">&nbsp;</div>
                            <div class="copy">
                                <p>&copy; <a href="/projetopds/index.jsp">Drogaria.Me</a>. Design by <a href="http://pdsufscar.appspot.com/" target="blank">CardBoardBox Software.</a></p>
                            </div>
                        </div>
                    </div>            
                </div>
                <!-- End Footer -->
                </body>
                </html>