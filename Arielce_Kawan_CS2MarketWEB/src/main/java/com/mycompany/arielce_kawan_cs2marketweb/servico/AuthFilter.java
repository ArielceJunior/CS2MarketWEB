/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.servico;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author tulio
 */

@WebFilter(urlPatterns = {"/*"})
/*Um filtro em Java EE é uma classe Java que pode ser usada para interceptar solicitações a um aplicativo antes que elas cheguem a 
um servlet ou JSP. Isso é útil para verificar se um usuário está logado antes de permitir acesso a páginas restritas.*/
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Configuração de inicialização do filtro, se necessário.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Obter o caminho da requisição
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        // String path = httpRequest.getServletPath();
        //System.out.println("PATH:" + path);
        // Verifica se "user" está na sessão
        // System.out.println("USER: "+httpRequest.getSession().getAttribute("user"));
        if (path.startsWith("/public/") || path.equalsIgnoreCase("/login.jsp")
                || path.equalsIgnoreCase("/com/mycompany/Arielce_Kawan_CS2MarketWEB/controlador/LoginControlador")
                || path.equalsIgnoreCase("/com/mycompany/Arielce_Kawan_CS2MarketWEB/controlador/LogountControlador")
                || path.equalsIgnoreCase("/index.jsp") || path.equalsIgnoreCase("/menu.jsp")|| path.equalsIgnoreCase("/CadastroUsuario.jsp") || path.equalsIgnoreCase("C:/Users/ariel/Documents/NetBeansProjects/Arielce_Kawan_CS2MarketWEB/src/main/java/com/mycompany/arielce_kawan_cs2marketweb/imagens/Counter-Strike-2-pode-chegar-no-dia-27-de-setembro-revela-teaser-da-Valve-912x569.jpg")
                || path.contains("/css/") || path.contains("/js/") || path.contains("/imagens/")) {
            chain.doFilter(request, response); // Continuar sem bloquear essas requisições
        } else {
            if (httpRequest.getSession().getAttribute("user") == null) {
                httpResponse.sendRedirect("/Arielce_Kawan_CS2MarketWEB/login.jsp"); // Redirecionar para a página de login

            } else {
                chain.doFilter(request, response); // Usuário está logado, continue com a solicitação.
            }
        }
    }

    @Override
    public void destroy() {
        // Recursos de limpeza do filtro, se necessário.
    }
}
