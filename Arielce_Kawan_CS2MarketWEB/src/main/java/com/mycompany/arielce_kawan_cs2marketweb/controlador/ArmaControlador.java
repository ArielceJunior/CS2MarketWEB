/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.controlador;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.ArmaDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Arma;
import com.mycompany.arielce_kawan_cs2marketweb.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tulio
 */
@WebServlet(WebConstantes.BASE_PATH + "/ArmaControlador")
public class ArmaControlador extends HttpServlet {

    private ArmaDAO armaDAO;
    private Arma arma;
    String idArma = "";
    String nomeArma = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        armaDAO = new ArmaDAO();
        arma = new Arma();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idArma = request.getParameter("idArma");
            nomeArma = request.getParameter("nomeArma");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            switch (opcao) {
                case "cadastrar":  cadastrar(request, response); break;
                case "editar":  editar(request, response); break;
                case "confirmarEditar":  confirmarEditar(request, response); break;
                case "excluir":  excluir(request, response); break;
                case "confirmarExcluir":  confirmarExcluir(request, response); break;
                case "cancelar":  cancelar(request, response); break;
                default:
                    throw new IllegalArgumentException("Opção inválida"+opcao);
            }
          

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são numeros válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        arma.setNomeArma(nomeArma);
        armaDAO.salvar(arma);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idArma", idArma);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeArma", nomeArma);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idArma", idArma);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeArma", nomeArma);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        arma.setIdArma(Integer.valueOf(idArma));
        arma.setNomeArma(nomeArma);
        armaDAO.alterar(arma);
        cancelar(request, response);
    }
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        arma.setIdArma(Integer.valueOf(idArma));
        arma.setNomeArma(nomeArma);
        armaDAO.excluir(arma);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idArma", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeArma", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Arma> armas = armaDAO.buscarTodas();
        request.setAttribute("armas", armas);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroArma.jsp");
        dispatcher.forward(request, response);

    }
    
    public void validaCampos(){
        if(nomeArma==null || nomeArma.isEmpty()){
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}
