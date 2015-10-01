<%-- 
    Document   : cadastroRemedio
    Created on : 23/09/2014, 12:35:04
    Author     : Mitsuoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="css/images/favicon.ico" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <script type="text/javascript" src="js/funcoes.js"></script>
    </head>
    <body>
        <%@include file="recuperaSession.jsp"%>
        <div id="cadastro">
            <h1 style="text-align: center"><a href="/projetopds/index.jsp">Drogaria.Me</a></h1>
            <div id="login-admin2">
                <p><label class="userName" style="">Olá, <%=user.getNome()%>!</a></label>              
            </div>      
            <br><br><br>
            <label style="margin-left: 40%; font-size: 24px; color: #01B508;">Cadastro de Remédios</label><br>
            <form id="newUser" method="post" action="AcaoRemedio">
                <table>
                    <tr><br/></tr>
                    <tr><td></br></br></br></td><td style="text-align: left; color:#8A8A8A">(<font color="red">*</font>) - Campos obrigatórios.<input type="hidden" name="acao" id="acao" value="adicionar"/></td>
                    <center style="border: 3px solid;">A venda de produtos tarja preta ou qualquer medicamento vendido apenas sob receitas médicas é inteiramente proibida de comercialização, por favor, não cadastre este tipo de produto. De acordo com o Termo 1 dos Termos de Compromisso
                        do site Drogaria.Me, o produto anunciado é de total responsabilidade do seu anunciante. Para mais informações, ler os <a href="/projetopds/termoderesponsa">Termos de Compromisso</a>.</center>
                    <td></br></td></tr>
                    <tr><td class="labelTd">Nome: (<font color="red">*</font>)</td><td><input type="text" name="nome_remedio" size="40" id="pNome" value="Informe o nome do remedio" onfocus="EmptyField(this.id);" onblur="VerificaPNome(document.getElementById('pNome').value), EmptyField2(this.id)" onkeyup="VerificaPNome(document.getElementById('pNome').value);"/></td><td><div id="alertPNome"></div></td></tr>
                    <tr><td class="labelTd">Descricao: (<font color="red">*</font>)  </td><td><textarea rows="10" style="background-color:#9FE073" cols="52" name="descricao" id="descricao" onfocus="EmptyField(this.id);" onblur="VerificaDescricao(document.getElementById('descricao').value), EmptyField2(this.id)" onkeyup="VerificaDescricao(document.getElementById('descricao').value);"/></textarea></td><td><div id="alertDescricao"></div></td></tr>
                    <tr><td class="labelTd">Validade: (<font color="red">*</font>)</td><td><input type="text" name="validade" size="40" maxlength="20" id="validade" value="Informe a data de validade do remedio" onfocus="EmptyField(this.id);" onkeyup="VerificaData(document.getElementById('validade').value);"/></td><td><div id="alertData"></div></td></tr>
                    <tr><td class="labelTd">Preco: (<font color="red">*</font>)</td><td> <input type="text" name="preco" size="40" maxlength="20" id="preco" value="Informe o preco do remedio" onfocus="EmptyField(this.id);" onkeyup="VerificaPreco(document.getElementById('preco').value);"/></td><td><div id="alertPreco"></div></td></tr>
                    <tr><td class="labelTd">URL da foto: (<font color="red">*</font>)</td><td> <input type="text" name="foto" size="40" maxlength="300" id="foto" value="Informe a url da foto do remedio" onfocus="EmptyField(this.id);" onkeyup="VerificaConteudo(document.getElementById('foto').value);"/></td><td><div id="alertConteudo"></div></td></tr>



                    <tr><td class="labelTd">Tipo da Unidade: (<font color="red">*</font>)</td><td><select name="tipo_unidade" id="tipo_unidade" onchange="VerificaUnidadeMedida(document.getElementById('tipo_unidade').value)">
                                <option value="">Selecione o tipo</option>
                                <option value="capsula">Cápsulas</option>
                                <option value="comprimido">Comprimidos</option>
                                <option value="gotas">Gotas</option>
                                <option value="pomada">Pomada</option>
                            </select></td><td><div id="alertUM"></div></td></tr>


                    <tr><td><td><p>Informe a quantidade restante por tipo de unidade:</p></td></td></tr>
                    <tr><td class="labelTd">Quantidade por Unidade: (<font color="red">*</font>)</td><td><input type="text" name="quantidade_tipo" size="40" id="quantidade_tipo" value="Informe a quantidade restante" onfocus="EmptyField(this.id);" onblur="VerificaQuantidade(document.getElementById('quantidade_tipo').value), EmptyField2(this.id)" onkeyup="VerificaQuantidade(document.getElementById('quantidade_tipo').value);"/></td><td><div id="alertQuantidade"></div></td></tr>

                    <tr><td><td><p>Dosagem do principio ativo por unidade (em milígramas):</p></td></td></tr>
                    <tr><td class="labelTd">Dose por Unidade: (<font color="red">*</font>)</td><td><input type="text" name="dose" size="40" id="dose" value="Informe a dose do remedio" onfocus="EmptyField(this.id);" onblur="VerificaDose(document.getElementById('dose').value), EmptyField2(this.id)" onkeyup="VerificaDose(document.getElementById('dose').value);"/></td><td><div id="alertDose"></div></td></tr>

                    <tr><td class="labelTd">Tipo do Remedio: (<font color="red">*</font>)</td><td><select name="tipoRemedio" id="tipoRemedio" onchange="VerificaTipoRemedio(document.getElementById('tipoRemedio').value)">
                                <option value="">Selecione o tipo</option>
                                <option value="generico">Generico</option>
                                <option value="nao generico">Não Generico</option>                                                                
                            </select></td><td><div id="alertUM"></div></td></tr>


                    <tr><td></td><td colspan="2" style="float: right; width: 280px; padding-top: 5px;"><a href="index.jsp">Voltar à Pagina Inicial</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="but" type="submit" value="Cadastrar"></td></tr>
                </table>
                <input type="hidden" id="email" name="email" value="<%=user.getEmail()%>" />
            </form>
            <br><br>
        </div>
    </body>
</html>
