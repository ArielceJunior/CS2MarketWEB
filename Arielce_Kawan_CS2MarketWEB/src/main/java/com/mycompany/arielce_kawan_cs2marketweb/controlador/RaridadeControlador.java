/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.controlador;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.RaridadeDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Raridade;
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
@WebServlet(WebConstantes.BASE_PATH + "/RaridadeControlador")
public class RaridadeControlador extends HttpServlet {

    private RaridadeDAO raridadeDAO;
    private Raridade raridade;
    String idRar = "";
    String nomeRar = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        raridadeDAO = new RaridadeDAO();
        raridade = new Raridade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idRar = request.getParameter("idRar");
            nomeRar = request.getParameter("nomeRar");
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
        raridade.setNomeRar(nomeRar);
        raridadeDAO.salvar(raridade);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idRar", idRar);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nomeRar", nomeRar);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idRar", idRar);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nomeRar", nomeRar);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        raridade.setIdRar(Integer.valueOf(idRar));
        raridade.setNomeRar(nomeRar);
        raridadeDAO.alterar(raridade);
        cancelar(request, response);
    }
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        raridade.setIdRar(Integer.valueOf(idRar));
        raridade.setNomeRar(nomeRar);
        raridadeDAO.excluir(raridade);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idRar", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nomeRar", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Raridade> raridades = raridadeDAO.buscarTodas();
        request.setAttribute("raridades", raridades);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroRaridade.jsp");
        dispatcher.forward(request, response);

    }
    
    public void validaCampos(){
        if(nomeRar==null || nomeRar.isEmpty()){
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}
