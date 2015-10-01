<%@page import="model.BEANUsuario"%>

<%
  //recupera session
  HttpSession s = request.getSession(false);
  BEANUsuario user = null;
  boolean logado = false;
  if (null != s && (BEANUsuario) s.getAttribute("Usuario") != null) {
    logado = true;
    user = (BEANUsuario) s.getAttribute("Usuario");
  }
%>