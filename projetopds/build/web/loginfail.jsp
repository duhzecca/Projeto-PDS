<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>Drogaria.Me - Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  <script type="text/javascript">
      function exibeAlertaCadastro(x){
        alert(x);
      }
      function VerificaEmail(dado)
      {
          var expr = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;

          if(expr.test(dado)){
              return true
          }
          else {
              window.location.href ='loginfail.jsp';
              return false
          }
      }
    </script>
  </head>
  <body>
    <% 
        String x = (String)request.getAttribute("msgCadastro");
        if(x != null){
          //
    %>
    <script>
      exibeAlertaCadastro('<%=x%>');
    </script>
    <%
       }
    %>
    <div id="login">
      <h1 style="text-align: center"><a href="index.jsp" title="Login">XÙLer</a></h1><br><br><br>
      <label style="margin-left: 23%; font-size: 24px; color: #01B508;">Acesso de Usu·rio</label>
      <p style="text-align: center; color: red"> Email ou senha incorretos!</p>
      <form id="loginForm" method="post" onsubmit="return VerificaEmail(document.getElementById('usuarioLogin').value)" action="ValidaLogin">
        <label>Email</label><br>
        <input type="text" name="usuarioLogin" id="usuarioLogin" class="field" size="30"/><br><br>
        <label>Senha</label><br>
        <input type="password" name="senhaLogin" class="field" size="30"/><br>
        <a href="/projetopds/esqueceuSenha.jsp" style="font-size: 12px;">Esqueci minha senha</a><br><br>
        <input type="checkbox"/>
        <label style="font-size: 15px;">Lembrar-me</label>
        <input type="submit" id="entrar" value="Entrar" style="font-size: 24px; margin-left: 160px;">
        <input type="hidden" name="acao" id="acao" value="login" />
      </form>
      <br><br>
    </div>
    <div id="posLogin">
      <a href="index.jsp" style="float: left">Voltar a Pagina Inicial</a>
      <a href="cadastro.jsp" style="float: right">Cadastrar-se</a>
    </div>
  </body>
</html>
