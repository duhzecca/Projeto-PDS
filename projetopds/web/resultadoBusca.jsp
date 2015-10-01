<%@page import="java.util.List"%>
<%@page import="model.BeanRemedio"%>
<%@page import="java.util.Iterator"%>
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
                    <ul class="categories">
                            <li>
                                <%  String generico = (String) (request.getAttribute("generico"));
                                    int limite_preco = (Integer) (request.getAttribute("preco"));%>

                                <h4>Filtrar</h4>
                                <ul>Por preco:            
                                    <form action="AcaoRemedio" id="filtro_preco" method="get">
                                        <p><input type="radio" id="p1" name="valor" value="10" onclick="document.forms['filtro_preco'].submit();">Até R$10,00</p>
                                        <p><input type="radio" id="p2" name="valor" value="30" onclick="document.forms['filtro_preco'].submit();" >Ate R$ 30,00</p>
                                        <p><input type="radio" id="p3" name="valor" value="70"onclick="document.forms['filtro_preco'].submit();">Ate R$ 70,00</p>
                                </ul>
                                <li>
                                </li>
                                <ul>Por tipo:
                                    <p><input type="radio" id="g1" name="generico" value="todos" onclick="document.forms['filtro_preco'].submit();">Todos</p>
                                    <p><input type="radio" id="g2" name="generico" value="generico" onclick="document.forms['filtro_preco'].submit();">Genérico</p>
                                    <p><input type="radio" id="g3" name="generico" value="nao generico" onclick="document.forms['filtro_preco'].submit();"   >Não Genérico</p>
                                </ul>
                            </li>
                            <script type="text/javascript">
                                <!--
                            var lim = <%=limite_preco%>;
                                var gen = '<%=generico%>';
                                console.log(lim);
                                if ((lim > 0) && (lim < 11)) {
                                    document.getElementById('p1').checked = true;
                                }
                                if ((lim > 10) && (lim < 31)) {
                                    document.getElementById('p2').checked = true;
                                }
                                if ((lim > 30) && (lim < 71)) {
                                    document.getElementById('p3').checked = true;
                                }
                                if (gen === "todos") {
                                    document.getElementById('g1').checked = true;
                                }
                                if (gen === "generico") {
                                    document.getElementById('g2').checked = true;
                                }
                                if (gen === "nao generico") {
                                    document.getElementById('g3').checked = true;
                                }


                                // -->
                            </script>
                        </ul>
                </div>
                <%} else { //se nao esta logado
                %>
                <div id="mainzin" class="shell">
                    <div id="sidebar">
                        <ul class="categories">
                            <li>
                                <%  String generico = (String) (request.getAttribute("generico"));
                                    int limite_preco = (Integer) (request.getAttribute("preco"));%>

                                <h4>Filtrar</h4>
                                <ul>Por preco:            
                                    <form action="AcaoRemedio" id="filtro_preco" method="get">
                                        <p><input type="radio" id="p1" name="valor" value="10" onclick="document.forms['filtro_preco'].submit();">Até R$10,00</p>
                                        <p><input type="radio" id="p2" name="valor" value="30" onclick="document.forms['filtro_preco'].submit();" >Ate R$ 30,00</p>
                                        <p><input type="radio" id="p3" name="valor" value="70"onclick="document.forms['filtro_preco'].submit();">Ate R$ 70,00</p>
                                </ul>
                                <li>
                                </li>
                                <ul>Por tipo:
                                    <p><input type="radio" id="g1" name="generico" value="todos" onclick="document.forms['filtro_preco'].submit();">Todos</p>
                                    <p><input type="radio" id="g2" name="generico" value="generico" onclick="document.forms['filtro_preco'].submit();">Genérico</p>
                                    <p><input type="radio" id="g3" name="generico" value="nao generico" onclick="document.forms['filtro_preco'].submit();"   >Não Genérico</p>
                                </ul>
                            </li>
                            <script type="text/javascript">
                                <!--
                            var lim = <%=limite_preco%>;
                                var gen = '<%=generico%>';
                                console.log(lim);
                                if ((lim > 0) && (lim < 11)) {
                                    document.getElementById('p1').checked = true;
                                }
                                if ((lim > 10) && (lim < 31)) {
                                    document.getElementById('p2').checked = true;
                                }
                                if ((lim > 30) && (lim < 71)) {
                                    document.getElementById('p3').checked = true;
                                }
                                if (gen === "todos") {
                                    document.getElementById('g1').checked = true;
                                }
                                if (gen === "generico") {
                                    document.getElementById('g2').checked = true;
                                }
                                if (gen === "nao generico") {
                                    document.getElementById('g3').checked = true;
                                }


                                // -->
                            </script>
                        </ul>
                    </div>

                    <%}%>
                    <!-- End Sidebar -->
                    <!-- Search Bar --
                    <!-- End Search Bar -->

                    <div id="search" style="height:70px; width: 100%; margin: 0 auto;">
                        <form action="AcaoRemedio" class='right' id='searchthis' method="get">
                            <% String search = (String) request.getAttribute("search");
                            %>
                            <input type="hidden" value="buscar" id="acao" name="acao"/>
                            <input type="hidden" value="<%=search%>"  name="oldSearch"/>

                            <input class="input-text" id="searchBox" name="searchBox" type="text" onFocus="javascript:if (this.value == 'Pesquisar...') {
                                        this.value = '';
                                    }" value="Pesquisar..."/>
                            <input class="searchbutton" id="submit-button" type="submit" value="Go"  />
                        </form>
                    </div>

                    <!-- Content -->
                    <div id="content">
                        <!-- Products -->
                        <div class="products">
                            <h3>Resultado da Busca!</h3> <!-- por: string da busca -->

                            <div class="list">
                                <ul>
                                    <%
                                        List<BeanRemedio> listaRemedios = null;
                                        int items_page = 12;
                                        String generico = (String) (request.getAttribute("generico"));
                                        int limite_preco = (Integer) (request.getAttribute("preco"));
                                        int nPages = (Integer) (request.getAttribute("n_of_pages"));
                                        int current_page = (Integer) (request.getAttribute("page"));
                                        int items = 0;

                                        if (request.getAttribute("listaRemedios") != null) {
                                            listaRemedios = (List<BeanRemedio>) request.getAttribute("listaRemedios");
                                            if (current_page == nPages) {
                                                items = listaRemedios.size();
                                            } else {
                                                items = current_page * items_page;
                                            }
                                        }
                                        if (listaRemedios.isEmpty()) {

                                    %>
                                    Sua busca não retornou resultados.
                                    <%} else {
                                        for (int j = (items_page * current_page) - items_page; j < items; j++) {
                                            BeanRemedio l = listaRemedios.get(j);%>                            
                                    <li>                                    
                                        <div class="product">


                                            <div class="list" onclick="sub_remedio(this);">
                                                <form name="form" id="id_change" method="get" action="remedio">
                                                    <input style="visibility: hidden;"name=id value="<%=l.getId_remedio()%>"></input>
                                                </form>
                                                <a href="javascript:void(0);" onclick=""><img src="<%= l.getFoto()%>" alt="Img" /></a><p></p>
                                                <div class="list-text" style="font-weight: bold; font-size: 16px; "><p><%=l.getNome()%></p></div>
                                                <div class="list-text"><p><%=l.getDescricao()%></p></div>
                                                <div class="list-text"><p><b>Validade:</b> <%=l.getValidade()%></p></div>                                    

                                                <a href="#" class="buy-btn">COMPRE <span class="price"><span class="low">R$</span><%=l.getReal()%><span class="high"><%=l.getCentavos()%></span></span></a>
                                            </div>
                                        </div>
                                        <!-- <div class="button"><a href="javascript:void(0);" onclick=""></a></div> -->                                    
                                    </li>

                                    <script>
                                        var id = <%=l.getId_remedio()%>;
                                        var set_id = document.getElementById("id_change").id + id;
                                        document.getElementById("id_change").id = set_id;
                                        function sub_remedio(div_form) {
                                            console.log(div_form);
                                            var chil = div_form.children[0].getAttribute("id");
                                            console.log(chil);
                                            var form = document.getElementById(chil);
                                            form.submit();
                                        }
                                    </script>
                                    <%}
                                        }%>
                                </ul>
                                <div class="clear-float"></div>
                            </div>

                        </div>
                        <div class="cl">&nbsp;</div>
                        <%
                            //INICIO PAGINAÇÃO
                            if (current_page > 1) {
                                String buffer = "<div class='page'><a href='AcaoRemedio?acao=buscar&valor=" + limite_preco + "&searchBox=" + search + "&page=" + (current_page - 1) + "'>Anterior</a></div>";
                        %>
                        <%= buffer%>
                        <%}
                            for (int i = 1; i <= nPages; i++) {
                                if (i == current_page) {
                                    String a = "<div class='page'><a class='ativo' href='AcaoRemedio?generico=" + generico + "&acao=buscar&valor=" + limite_preco + "&searchBox=" + search + "&page=" + i + "'>" + i + "</a></div>";
                        %><%=a%><%
                        } else {
                            String b = "<div class='page' ><a href='AcaoRemedio?generico=" + generico + "&acao=buscar&valor=" + limite_preco + "&searchBox=" + search + "&page=" + i + "'>" + i + "</a></div>";
                        %><%=b%><%
                                }
                            }
                            if (!(current_page == nPages)) {
                                String next = "<div class='page'><a href='AcaoRemedio?generico=" + generico + "&acao=buscar&valor=" + limite_preco + "&searchBox=" + search + "&page=" + (current_page + 1) + "'>Próximo</a></div>";
                        %> <%=next%> <%
                            }%>
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
                                    <p>&copy; <a href="#">Drogaria.Me</a>. Design by <a href="http://pdsufscar.appspot.com/">CardBoardBox Software.</a></p>
                                </div>
                            </div>
                        </div>            
                    </div>
                    <!-- End Footer -->
                    </body>
                    </html>