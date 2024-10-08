

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
        <h1>Cadastro Raridade</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/RaridadeControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="idRar" value="${idRar}" />
                <p><label>Raridade:</label> <input type="text" name="nomeRar" value="${nomeRar}" size="40" /> </p>
                <td> 
                    <input type="submit" value="Salvar" name="Salvar"  /> 
                </td>
            </form>

            <form  name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/RaridadeControlador" method="get">
                <td>
                    <input type="submit" value="Cancelar" name="Cancelar"  />
                </td>
                <input type="hidden" name="opcao" value="cancelar" />
            </form>
        </table>
        ${mensagem}

        <table border="1">
            <c:if test="${not empty raridades}">
                <tr>
                    <th>ID</th>
                    <th>Raridade</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr> 
            </c:if>

            <c:forEach var="raridade" items="${raridades}">
                <tr>
                    <td>${raridade.idRar}</td>
                    <td>${raridade.nomeRar}</td>                   
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/RaridadeControlador" method="get">
                            <input type="hidden" name="idRar" value="${raridade.idRar}" >
                            <input type="hidden" name="nomeRar" value="${raridade.nomeRar}" >
                            <input type="hidden" name="opcao" value="editar" >
                            <button type="submit">Editar</button>
                        </form>    
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/RaridadeControlador" method="get">
                            <input type="hidden" name="idRar" value="${raridade.idRar}" >
                            <input type="hidden" name="nomeRar" value="${raridade.nomeRar}" >                           
                            <input type="hidden" name="opcao" value="excluir" >
                            <button type="submit">Excluir</button>
                        </form>    
                    </td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
