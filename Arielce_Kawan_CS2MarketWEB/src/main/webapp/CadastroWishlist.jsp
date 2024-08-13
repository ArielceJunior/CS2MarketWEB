

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <script>

        function submitForm(opcaoValue) {

            document.getElementById("opcao").value = opcaoValue;
            document.getElementById("cadastroForm").submit();
        }


    </script>


    <body>
        <h1>Cadastro Wishlist</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/WishlistControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idWish" value="${idWish}" />
                <p><label>Usuário:</label>
                    <select name="wishUser">
                     <c:forEach var="usuario" items="${wishlist}">
                         <c:choose> 
                            
                            <c:when test="${usuario.username eq wishUser}">
                                <option selected value="${usuario.username}">${usuario.username}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${usuario.username}">${usuario.username}</option>
                            </c:otherwise>
                        </c:choose>
                     </c:forEach> 
                                  </select>
                </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/WishlistControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty wishlist}">
                <tr>
                    <th>ID</th>
                    <th>Coleção</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="wishlist" items="${wishlist}">
                <tr>
                    <td>${wishlist.idWish}</td>
                    <td>${wishlist.wishUser}</td>                   
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/WishlistControlador" method="get">
                            <input type="hidden" name="idWish" value="${wishlist.idWish}" >
                            <input type="hidden" name="wishUser" value="${wishlist.wishUser}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/WishlistControlador" method="get">
                            <input type="hidden" name="idWish" value="${wishlist.idWish}" >
                            <input type="hidden" name="wishUser" value="${wishlist.wishUser}"                     
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
