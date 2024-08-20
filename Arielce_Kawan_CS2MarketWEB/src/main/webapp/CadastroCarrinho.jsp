

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
        <h1>Carrinho</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CarrinhoControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idCar" value="${idCar}" />
                <p><label>Skin:</label>
                    <select name="skinSkin">
                     <c:forEach var="skin" items="${skins}">
                         <c:choose> 
                            
                            <c:when test="${skin.idSkin eq skinCar}">
                                <option selected value="${skin.idSkin}">${skin.skinCar}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${skin.idSkin}">${skin.nome}</option>
                            </c:otherwise>
                        </c:choose>
                     </c:forEach> 
                                  </select>
                </p>
                
                <p><label>Valor:</label> <input type="number" name="valor" value="${valor}" size="10" /> </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CarrinhoControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty colecoes}">
                <tr>
                    <th>ID</th>
                    <th>Skin</th>
                    <th>Valor</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="carrinho" items="${colecoes}">
                <tr>
                    <td>${carrinho.idCar}</td>
                    <td>${carrinho.skinCar.nome}</td>
                    <td>${carrinho.valor}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CarrinhoControlador" method="get">
                            <input type="hidden" name="idCar" value="${carrinho.idCar}" >
                            <input type="hidden" name="skinCar" value="${carrinho.skinCar.idSkin}" >
                            <input type="hidden" name="valor" value="${carrinho.valor}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CarrinhoControlador" method="get">
                             <input type="hidden" name="idCar" value="${carrinho.idCar}" >
                            <input type="hidden" name="skinCar" value="${carrinho.skinCar.idSkin}" >
                            <input type="hidden" name="valor" value="${carrinho.valor}" >                       
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
