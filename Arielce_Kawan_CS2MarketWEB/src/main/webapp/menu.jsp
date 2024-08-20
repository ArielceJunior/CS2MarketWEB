<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
       
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/ArmaControlador?opcao=cancelar">Arma</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/RaridadeControlador?opcao=cancelar">Raridade</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/ColecaoControlador?opcao=cancelar">Coleção</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/SkinControlador?opcao=cancelar">Skin</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/WishlistControlador?opcao=cancelar">Wishlist</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/CarrinhoControlador?opcao=cancelar">Carrinho</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/LoginControlador">Logout</a></li>
                
            </ul>
        </nav>
    </body>
</html>
