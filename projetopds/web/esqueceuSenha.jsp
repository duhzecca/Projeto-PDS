<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>Esqueceu sua senha?</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="css/images/favicon.ico" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  </head>
  <body>
    <div id="login">
      <h1 style="text-align: center"><a href="login.jsp" title="Login">Remédios</a></h1><br><br><br>
      <label style="margin-left: 50px; font-size: 24px; color: #01B508;">Deseja uma nova Senha?</label>
      <form id="loginForm" method="post" onsubmit="return VerificaEmail(document.getElementById('usuarioLogin').value)" action="ValidaLogin">
          </br>
              <label style="font-size: 14px;">Coloque seu E-mail Cadastrado:</label><br>
        <input type="text" name="email" id="email" class="field" size="30"/><br><br>
                <p style="font-size: 14px;">Nós lhe enviaremos uma senha para o seu e-mail cadastrado. Por favor, verifique seu
                    e-mail em alguns instantes. Agradecemos seu uso :)</p></br>
        <input type="submit" id="entrar" value="Enviar" style="font-size: 20px; margin-left: 150px;">
        <input type="hidden" name="acao" id="acao" value="novasenha" />
      </form>
      <br><br>
    </div>
    <div id="posLogin">
      <a href="index.jsp" style="float: left; color: #2FC022">Voltar a página inicial</a>
      <a href="cadastro.jsp" style="float: right; color: #2FC022 ">Cadastrar-se</a>
    </div>
  </body>
</html>