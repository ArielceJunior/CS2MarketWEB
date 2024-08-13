

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
        <h1>Cadastro Coleção</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ColecaoControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idCol" value="${idCol}" />
                <p><label>Coleção:</label> <input type="text" name="nome" value="${nome}" size="40" /> </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ColecaoControlador" method="get">
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
                    <th>Coleção</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="colecao" items="${colecoes}">
                <tr>
                    <td>${colecao.idCol}</td>
                    <td>${colecao.nome}</td>                   
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ColecaoControlador" method="get">
                            <input type="hidden" name="idCol" value="${colecao.idCol}" >
                            <input type="hidden" name="nome" value="${colecao.nome}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ColecaoControlador" method="get">
                            <input type="hidden" name="idCol" value="${colecao.idCol}" >
                            <input type="hidden" name="nome" value="${colecao.nome}" >                           
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
