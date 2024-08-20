<%-- 
    Document   : CadastroArma
    Created on : 8 de jul. de 2024, 21:42:09
    Author     : ariel
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.ArmaDAO"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.RaridadeDAO"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.SkinDAO"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Skin"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Arma"%>
<%@page import="com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Raridade"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <body>
        <h1>Cadastro Skin</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SkinControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idSkin" value="${idSkin}" />
                <p><label>Nome:</label> <input type="text" name="nome" value="${nome}" size="40" required/> </p>
                <p><label>Preço:</label> <input type="number" name="preco" value="${preco}" size="10" required/> </p>
                <p><label>Arma:</label>
                    <select name="armaSkin">
                     <c:forEach var="arma" items="${armas}">
                         <c:choose> 
                            
                            <c:when test="${arma.idArma eq armaSkin}">
                                <option selected value="${arma.idArma}">${arma.nomeArma}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${arma.idArma}">${arma.nomeArma}</option>
                            </c:otherwise>
                        </c:choose>
                     </c:forEach> 
                                  </select>
                </p>
                <p><label>Raridade:</label>
                    <select name="raridadeSkin">
                     <c:forEach var="raridade" items="${raridades}">
                         <c:choose> 
                            
                            <c:when test="${raridade.idRar eq raridadeSkin}">
                                <option selected value="${raridade.idRar}">${raridade.nomeRar}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${raridade.idRar}">${raridade.nomeRar}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                              </select>
                </p>
                
                <p><label>Coleção:</label>
                    <select name="colecaoSkin">
                     <c:forEach var="colecao" items="${colecoes}">
                         <c:choose> 
                            
                            <c:when test="${colecao.idCol eq colecaoSkin}">
                                <option selected value="${colecao.idCol}">${colecao.nome}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${colecao.idCol}">${colecao.nome}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                              </select>
                </p>    
              
                
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SkinControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty skins}">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Arma</th>
                    <th>Raridade</th>
                    <th>Coleção</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="skin" items="${skins}">
                <tr>
                    <td>${skin.idSkin}</td>
                    <td>${skin.nome}</td>
                    <td>${skin.preco}</td>
                    <td>${skin.armaSkin.nomeArma}</td>
                    <td>${skin.raridadeSkin.nomeRar}</td>
                    <td>${skin.colecaoSkin.nome}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SkinControlador" method="get">
                            <input type="hidden" name="idSkin" value="${skin.idSkin}" >
                            <input type="hidden" name="nome" value="${skin.nome}" >
                            <input type="hidden" name="preco" value="${skin.preco}" >
                              <input type="hidden" name="armaSkin" value="${skin.armaSkin.idArma}" >
                              <input type="hidden" name="raridadeSkin" value="${skin.raridadeSkin.idRar}" >
                              <input type="hidden" name="colecaoSkin" value="${skin.colecaoSkin.idCol}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/SkinControlador" method="get">
                            <input type="hidden" name="idSkin" value="${skin.idSkin}" >
                            <input type="hidden" name="nome" value="${skin.nome}" >
                            <input type="hidden" name="preco" value="${skin.preco}" >
                              <input type="hidden" name="armaSkin" value="${skin.armaSkin.idArma}" >
                              <input type="hidden" name="raridadeSkin" value="${skin.raridadeSkin.idRar}" >
                              <input type="hidden" name="colecaoSkin" value="${skin.colecaoSkin.idCol}" >
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
