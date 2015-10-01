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
                        <h3>Ajuda e Termo de Compromisso</h3>
                        <p><b>1. Objeto</b></br>
                        Os serviços do presente objeto consiste em oferecer e hospedar espaços no sistema para que os 
                        usuários vendedores/doadores possam anunciar seus produtos e compradores/receptores possam solicitar
                        ou comprar os produtos ofertados por meio da divulgação dos contatos destes atores da transação.
                        A Drogaria.Me possibilita, portanto, o contato e a negociação diretos entre vendedor/doador e 
                        comprador/receptor sem qualquer intervenção, na negociação ou concretização da transação.
                        É importante ressaltar que a Drogaria.Me não fornece qualquer produto ou serviço anunciado em seu site.
                               </p></br>
                        <p><b>2. Capacidade de cadastro</b></p>
                        <p>O sistema Drogaria.Me estará disponível somente para pessoas físicas e jurídicas com 
                            capacidade legal e que não tenha sido excluída do sistema definitivamente ou temporariamente.
                        O usuário deverá se comprometer em não fornecer seus dados de acesso a terceiros.
                        </p></br>
                        <p><b>3. Cadastro</b></p>
                        <p>A confirmação do cadastro de usuário só se dará após o preenchimento de todos os campos obrigatórios 
                            do formulário de cadastro com informações verdadeiras e precisas. E caso não sejam a Drogaria.Me 
                            terá total direito em excluir temporariamente ou definitivamente o usuário, sem prejuízo de qualquer 
                        outra medida.</p></br>
                        <p><b>4. Produtos anunciados</b></p>
                        <p>O usuário poderá anunciar seu produto de acordo com as categorias e subcategorias existentes no 
                            sistema. Os anúncios poderá possuir fotos, textos, descrições e outras informações relevantes, 
                            desde que não viole nenhumas das leis em vigor, para a clara identificação do produto.
                        </p></br>
                        <p><b>5. Privacidade da Informação</b></p>
                        <p>Todos os dados do sistema, com exceção das informações públicas, aquelas necessárias para a 
                            consolidação das transações, serão armazenados em servidores seguros. Todas as medidas possíveis
                            para o bom funcionamento do sistema e necessárias para a segurança e sigilo dos dados serão tomadas
                            periodicamente.
                        </p></br>
                        <p><b>6. Obrigações dos Usuários</b></p>
                        <p>A manifestação de interesse do usuário comprador deve ser realizada durante o prazo de vigência do anúncio ou até o esgotamento do estoque.
                        O comprador terá a responsabilidade de efetuar o pagamento do produto, de acordo com as exigências do anúncio, bem como as taxas referentes a entrega dentro do prazo de vencimento.
                        O vendedor terá a responsabilidade de, após receber o pagamento, providenciar a entrega do produto de forma acordada e dentro da data estipulada
                        A Drogaria.Me não se responsabiliza pelas obrigações tributárias sobre as atividades dos usuários do site.
                        </p></br>
                        <p><b>7. Práticas vedadas</b></p>
                        <p>Os usuários não poderão interferir em negociações de outros usuários, nem divulgar informações não públicas. Atitudes estas passíveis de cancelamento parcial ou definitivo do sistema.
                        </p></br>
                        <p><b>8. Violação no sistema ou da base de dados</b></p>
                        <p>Não é permitida a utilização de qualquer tipo de equipamento tecnológico, bem como software, sistema ou meio a fim de acessar o banco de dados do sistema.
                        </p></br>
                        <p><b>9. Sanções</b></p>
                        <p>A Drogaria.Me tem o total direito de solicitar qualquer documento ou acessar qualquer dado de seus usuários.
                        </p></br>
                        <p><b>10. Responsabilidades</b></p>
                        <p>A Drogaria.Me não se responsabiliza pela veracidade dos dados e informações disponibilizadas por seus usuários, bem como pela qualidade, estado, integridade ou legitimidade dos produtos oferecidos ou adquiridos pelo sistema.
                        </p></br>
                        <p><b>11. Falhas no sistema</b></p>
                        <p>A Drogaria.Me não se responsabiliza por qualquer prejuízo, perda ou dano sofridos pelo usuário em razão de falhas na internet, sistema ou servidor utilizado pelo usuário.
                        </p></br>
                        <p><b>12. Tarifas e faturamento</b></p>
                        <p>O cadastro no sistema Drogaria.Me é gratuito. Ao comercializar um produto no Drogaria.Me, o site receberá um percentual da venda. Este percentual é informado no momento de cadastro de um produto para venda via Drogaria.Me.
                        </p></br>
                        <p><b>13. Sistema de reputação</b></p>
                        <p>O usuário da plataforma Drogaria.Me possui a seu dispor um sistema de qualificação, que permite que os compradores avaliem suas transações, bem como o vendedor de fornecer um feedback em relação as solicitações que é uma excelente ferramenta para que o comprador analise seu vendedor antes mesmo de efetuar a transação.
                        É importante ressaltar que todas as informações postadas no sistema de qualificação é de inteira responsabilidade de seus usuários.
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
                                <p>&copy; <a href="/projetopds/index.jsp">Drogaria.Me</a>. Design by <a href="http://pdsufscar.appspot.com/" target="blank">CardBoardBox Software.</a></p>
                            </div>
                        </div>
                    </div>            
                </div>
                <!-- End Footer -->
                </body>
                </html>