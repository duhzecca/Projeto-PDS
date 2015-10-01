/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var a, b, c, f, g, h, i = false;
var cpf,cep,rua = false;
////////////////////////////////FUNCOES DE VERIFICACAO DE DADOS
function VerificaPNome(dado){
    if(dado != ''){
        document.getElementById('alertPNome').innerHTML = '<img title="Nome OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertPNome').innerHTML = '<img title="Nome Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}
function VerificaSobrenome(dado){
    if(dado != ''){
        document.getElementById('alertSobrenome').innerHTML = '<img title="Sobrenome OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        b = true
        return true
    } else{
        document.getElementById('alertSobrenome').innerHTML = '<img title="Sobrenome Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        b = false
        return false
    }
}


function setaNoQuery(caminho){
    window.location="reader.html"+'?'+caminho;
}


function VerificaLogin(dado){
    if(dado != ''){
        document.getElementById('alertLogin').innerHTML = '<img title="Login OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        i = true
        return true
    } else{
        document.getElementById('alertLogin').innerHTML = '<img title="Login Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        i = false
        return false
    }
}

function VerificaCPF (campo) {
    if (vercpf(campo)){
        document.getElementById('alertCPF').innerHTML = '<img title="CPF OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        cpf = true
        return true
    }else {
        document.getElementById('alertCPF').innerHTML = '<img title="CPF Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        cpf = false
        return false
    }
}

function vercpf (cpf) {
    if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999")
        return false;
    add = 0;
    for (i=0; i < 9; i++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(9)))
        return false;
    add = 0;
    for (i = 0; i < 10; i ++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10)))
        return false;
    return true;
}
var data;
function VerificaData(dado)
{
    var expr = /^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])\/([1-9]|1[0,1,2])\/\d{4}$/;
    
    if(dado.match(expr)){
        document.getElementById('alertData').innerHTML = '<img title="Data OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        data = true
        return true
    }
    else {
        document.getElementById('alertData').innerHTML = '<img title="Data Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        data = false
        return false
    }
}


function VerificaSexo(dado){
    if(dado != ''){
        document.getElementById('alertSexo').innerHTML = '<img title="Sexo OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertSexo').innerHTML = '<img title="Selecione seu sexo!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}

function VerificaEmail(dado)
{
    var expr = /^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$/;
    
    if(expr.test(dado)){
        document.getElementById('alertEmail').innerHTML = '<img title="Email OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        f = true
        return true
    }
    else {
        document.getElementById('alertEmail').innerHTML = '<img title="Email Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        f = false
        return false
    }
}

function VerificaSenha(dado){
    if(dado.length >= 6 && dado.length <= 40){
        document.getElementById('alertSenha').innerHTML = '<img title="Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        g = true
        return true;
    }else{
        document.getElementById('alertSenha').innerHTML = '<img title="Senha deve ter entre 6 e 40 caracteres" src="css/images/icoErro.gif" alt="Erro"/>'
        g = false
        return false;
    }
}

function VerificaSenhasIguais(senha1, senha2){
    if(senha1 == senha2 && senha1.length >= 6){
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        h = true
        return true;
    }else{
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        h = false
        return false;
    }
}

function VerificaAutor(dado){
    if(dado != ''){
        document.getElementById('alertAutor').innerHTML = '<img title="Autor OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertAutor').innerHTML = '<img title="Autor Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}

function VerificaCapa(dado){
    if(dado != ''){
        document.getElementById('alertCapa').innerHTML = '<img title="Capa OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertCapa').innerHTML = '<img title="Capa Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}

function VerificaConteudo(dado){
    if(dado != ''){
        document.getElementById('alertConteudo').innerHTML = '<img title="Conteudo OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        a = true
        return true
    } else{
        document.getElementById('alertConteudo').innerHTML = '<img title="Conteudo Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        a = false
        return false
    }
}
var preco,descricao;

function VerificaDescricao(dado){
    if(dado != ''){
        document.getElementById('alertDescricao').innerHTML = '<img title="Descrição OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        descricao = true
        return true
    } else{
        document.getElementById('alertDescricao').innerHTML = '<img title="Descrição Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        descricao = false
        return false
    }
}

function VerificaPreco(dado){
    
    if(/^\d{0,8}(\.\d{1,4})?$/.test(dado))
    {
        document.getElementById('alertPreco').innerHTML = '<img title="Conteudo OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        preco = true
        return true
    } else{
        document.getElementById('alertPreco').innerHTML = '<img title="Conteudo Inválido!" src="css/images/icoErro.gif" alt="Erro"/>'
        preco = false
        return false
    }
}


function VerificaEditora(dado){
    if(dado != ''){
        document.getElementById('alertEditora').innerHTML = '<img title="Editora OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertEditora').innerHTML = '<img title="Selecione a editora!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}
var unidade_medida;
function VerificaUnidadeMedida(dado){
    if(dado != ''){
        document.getElementById('alertUM').innerHTML = '<img title="Unidade de medida OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        unidade_medida = true
        return true
    } else{
        document.getElementById('alertUM').innerHTML = '<img title="selecione Unidade de Medida!" src="css/images/icoErro.gif" alt="Erro"/>'
        unidade_medida = false
        return false
    }
    
}
var tipo_remedio;
function VerificaTipoRemedio(dado){
    if(dado != ''){
        document.getElementById('alertUM').innerHTML = '<img title="Tipo do Remedio OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        tipo_remedio = true
        return true
    } else{
        document.getElementById('alertUM').innerHTML = '<img title="Selecione Tipo do Remedio!" src="css/images/icoErro.gif" alt="Erro"/>'
        tipo_remedio = false
        return false
    }
    
}
var quantidade;
function VerificaQuantidade(dado){
    if(/^-?\d+\.?\d*$/.test(dado)){
        document.getElementById('alertQuantidade').innerHTML = '<img title="Quantidade OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        quantidade = true
        return true
    } else{
        document.getElementById('alertQuantidade').innerHTML = '<img title="entre com a Quantidade!" src="css/images/icoErro.gif" alt="Erro"/>'
        quantidade = false
        return false
    }
    
}

var dose;
function VerificaDose(dado){
    if(/^-?\d+\.?\d*$/.test(dado)){
        document.getElementById('alertDose').innerHTML = '<img title="Dose OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        dose = true
        return true
    } else{
        document.getElementById('alertDose').innerHTML = '<img title="entre com a dose em número!" src="css/images/icoErro.gif" alt="Erro"/>'
        dose = false
        return false
    }
    
}

function VerificaEndereco(dado){
    if(dado != ''){
        document.getElementById('alertRua').innerHTML = '<img title="Rua OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        rua = true
        return true
    } else{
        document.getElementById('alertRua').innerHTML = '<img title="Rua Invalido!" src="css/images/icoErro.gif" alt="Erro"/>'
        rua = false
        return false
    }
}


function VerificaTelefone(dado){
    var expr = /^\(?\d{2}\)?[\s-]?\d{5}-?\d{4}$/;

    if(expr.test(dado)){
        document.getElementById('alertTelefone').innerHTML = '<img title="Telefone OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        e = true
        return true
    } else{
        document.getElementById('alertTelefone').innerHTML = '<img title="Telefone Invalido!" src="css/images/icoErro.gif" alt="Erro"/>'
        e = false
        return false
    }
}

function VerificaCEP(number){
    var expr = /^\d{5}-?\d{3}$/;
    
    if(expr.test(number)){
       document.getElementById('alertCEP').innerHTML = '<img title="CEP OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        cep = true;
        return true;    
    }else{
      document.getElementById('alertCEP').innerHTML = '<img title="CEP Invalido!" src="css/images/icoErro.gif" alt="Erro"/>';
      cep = false;
      return false;  
    }
  
       
    
}


///////////////////////////FUNCOES PARA LIMPAR CAIXAS DE TEXTO
function EmptyField(id)
{
    var Fid = document.getElementById(id);
    var TheDefaultValue = Fid.defaultValue;
    var TheValue = Fid.value;

    if(TheDefaultValue == TheValue) //se quando ganhar foco, o conteudo for o default zera o campo
    {
        Fid.value = '';
    }
}

function EmptyField2(id)
{
    var Fid = document.getElementById(id);
    var TheDefaultValue = Fid.defaultValue;
    var TheValue = Fid.value;

    if(TheValue == '')//se o conteudo for vazio quando perder o foco, volta ao default
    {
        Fid.value = TheDefaultValue;
    }
}

///////////////////////////FUNCAO PARA LIBERAR O BOTAO DE CONTINUAR
function LiberaBotao()
{
    if(a && b && f && g && h && cpf && e && cep && rua){
        document.getElementById('cadastrar').disabled = false;
    }
    else{
        document.getElementById('cadastrar').disabled = true;
    }
}



////////////////////////////////////FUNCOES DA PAGINA GERENCIAR
var auxGerenciaFecha;  //variavel para guardar a input aberta.
function gerenciar(q, acao)
{
    if(q == 'c'){
        auxGerenciaFecha = 'c';
        if(acao == "adicionar"){
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">"+
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Nova Categoria\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"submit\" value=\"Adicionar categoria\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" id=\"catSelectBox\" name=\"catSelectBox\" value=\"oi\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else if(acao == "alterar"){
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Novo nome de Categoria\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"submit\" value=\"Alterar categoria\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else{
            document.getElementById('gerenciaCategoria').innerHTML = "<form method=\"post\" id=\"formCategory\" action=\"javascript:acoesCategoria();\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"submit\" value=\"Remover categoria\"/>"+
        "<input type=\"hidden\" id=\"nome\" name=\"nome\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }
    }else if(q == 't'){
        auxGerenciaFecha = 't';
        if(acao == "adicionar"){
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<input type=\"text\"id=\"nome\"  name=\"nome\" value=\"Novo Tipo\" onfocus=\"EmptyField(this.id);\"/><input type=\"submit\" value=\"Adicionar tipo\"/>"+
        "<input type=\"hidden\" id=\"tipoSelectBox\" name=\"tipoSelectBox\" value=\"oi\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else if(acao == "alterar"){
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\">"+
        "<select name=\"tipoSelectBox\" id=\"tipoSelectBox\"><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"text\" id=\"nome\" name=\"nome\" value=\"Novo nome de Tipo\" onfocus=\"EmptyField(this.id);\"><input type=\"submit\" value=\"Alterar tipo\"/>"+
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        }else{
            document.getElementById('gerenciaTipo').innerHTML = "<form method=\"post\" action=\"javascript:acoesTipo();\" id=\"formType\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\">"+
        "<select name=\"tipoSelectBox\" id=\"tipoSelectBox\"><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"hidden\" id=\"nome\" name=\"nome\"><input type=\"submit\" value=\"Remover Tipo\"/>" +
        "<input type=\"hidden\" id=\"acao\" name=\"acao\" value=\"remover\"/>"+
        "<input type=\"hidden\" id=\"logado\" name=\"logado\" value=\"1\"/>"+
        "</form>";

        }
    }else{
        auxGerenciaFecha = 'e';

        /*        if(acao == "adicionar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"add\"/><input type=\"submit\" value=\"Ok\"/></form>";*/
        if(acao == "adicionar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form method=\"post\" action=\"javascript:acoesEntidade();\" id=\"formEntidade\">" +
        "<label id=\"catSelect\">"+
        "<select name=\"catSelectBox\" id=\"catSelectBox\">" +
        "<option value=\"\">(Categorias)</option>" +
        "</select>" +
        "</label>" +
        "<label id=\"tipoSelect\" name=\"tipoSelect\">"+
        "<select><option>(Tipos)</option></select>"+
        "</label>" +
        "<input type=\"text\" name=\"mid\" id=\"mid\" value=\"Mid\" onfocus=\"EmptyField(this.id)\">"+
        "<input type=\"text\" name=\"nome\" id=\"nome\" value=\"Entidade\" onfocus=\"EmptyField(this.id)\">"+
        "<input type=\"text\" style=\"width: 260px\" name=\"descricao\" id=\"descricao\" value=\"Descricao\" onfocus=\"EmptyField(this.id)\">" +
        "<br><input type=\"submit\" value=\" + Categorias/Tipos\"/><br>"+
        "<input type=\"submit\" value=\"Adicionar\"/>"+
        "<input type=\"hidden\" name=\"acao\" value=\"adicionar\"/>"+
        "<input type=\"hidden\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        else if(acao == "alterar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form method=\"post\" action=\"javascript:acoesEntidade();\" id=\"formEntidade\">" +
        "<input type=\"text\" name=\"nome\" id=\"nome\" value=\"Entidade\" onfocus=\"EmptyField(this.id)\"/>"+
        "<input type=\"text\" name=\"catSelectBox\" id=\"catSelectBox\" value=\"Digite o novo nome\" onfocus=\"EmptyField(this.id);\"/>"+
        "<br><input type=\"hidden\" style=\"width: 220px\" name=\"descricao\" id=\"descricao\" value=\"Descricao\" onfocus=\"EmptyField(this.id);\"/>" +
        "<input type=\"text\" name=\"tipoSelectBox\"  style=\"width: 220px\" id=\"tipoSelectBox\" value=\"Digite a nova descricao\" onfocus=\"EmptyField(this.id);\"/>"+
        "<input type=\"hidden\" name=\"mid\" id=\"mid\" value=\"Mid\"/>"+
        "<br><input type=\"submit\" value=\"Alterar\"/>"+
        "<input type=\"hidden\" name=\"acao\" value=\"alterar\"/>"+
        "<input type=\"hidden\" name=\"logado\" value=\"1\"/>"+
        "</form>";
        /*        else if(acao == "alterar")
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"alt\"/><input type=\"submit\" value=\"Ok\"/></form>";*/
        else
            document.getElementById('gerenciaEntidade').innerHTML = "<form><input type=\"text\" value=\"remover\"/><input type=\"submit\" value=\"Ok\"/></form>";
    }
}

function gerenciaFecha()
{
    if(auxGerenciaFecha == 'c')
        document.getElementById('gerenciaCategoria').innerHTML = "";
    else if(auxGerenciaFecha == 't')
        document.getElementById('gerenciaTipo').innerHTML = "";
    else
        document.getElementById('gerenciaEntidade').innerHTML = "";
}











//////////////////////FUNCOES DE ORDENACAO

// Ordena pelo nome do usuário
function byname(user_a, user_b) {
    return user_a.nome > user_b.nome;
}

// Ordena pela idade do usuário
function byread(user_a, user_b) {
    return user_a.idade > user_b.idade;
}


var s1, s2;
function VerificacaoSenha(dado){
    if(dado.length == 0 ){
        s1 = false
        return false;
    }else  
          
    if(dado.length >= 6 && dado.length <= 40){
        document.getElementById('alertSenha').innerHTML = '<img title="Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        s1 = true
        return true;
    }else{
        document.getElementById('alertSenha').innerHTML = '<img title="Senha deve ter entre 6 e 40 caracteres" src="css/images/icoErro.gif" alt="Erro"/>'
        s1 = false
        return false;
    }
}

function VerificacaoSenhasIguais(senha1, senha2){
    if(senha2.length == 0 || senha1.length == 0){
        s2 = false
        return false;
    }else
        
    if(senha1 == senha2 && senha1.length >= 6){
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha OK" src="css/images/icoOk.jpg" alt="Ok"/>'
        s2 = true
        return true;
    }else{
        document.getElementById('alertSenha2').innerHTML = '<img title="Confirmação de Senha Inválida!" src="css/images/icoErro.gif" alt="Erro"/>'
        s2 = false
        return false;
    }
}
        
function LiberarBotao()
{
    
    if(s1 && s2){
        document.getElementById('alterarSenha').disabled = false;
    }
    else{
        document.getElementById('alterarSenha').disabled = true;
    }
}


