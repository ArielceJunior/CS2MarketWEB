/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.controlador;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.CarrinhoDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.SkinDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Carrinho;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Skin;
import com.mycompany.arielce_kawan_cs2marketweb.servico.WebConstantes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(WebConstantes.BASE_PATH + "/CarrinhoControlador")
public class CarrinhoControlador extends HttpServlet {
    private SkinDAO skinDAO;
    private Skin skin;
    private CarrinhoDAO carrinhoDAO;    
    private Carrinho carrinho;
    String idCar = "";
    String skinCar = "";
    String valor = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        skinDAO = new SkinDAO();
        skin = new Skin();
        carrinhoDAO = new CarrinhoDAO();
        carrinho = new Carrinho();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idCar = request.getParameter("idCar");
            skinCar = request.getParameter("skinCar");
            valor = request.getParameter("valor");
           
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
        carrinho.setValor(Double.valueOf(valor));
        carrinho.getSkin().setIdSkin(Integer.valueOf(skinCar));
        carrinhoDAO.salvar(carrinho);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idCar", idCar);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("skinCar", skinCar);
        request.setAttribute("valor", valor);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
   private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idCar", idCar);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("skinCar", skinCar);
        request.setAttribute("valor", valor);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        carrinho.setIdCar(Integer.valueOf(idCar));
        carrinho.getSkin().setIdSkin(Integer.valueOf(skinCar));
        carrinho.setValor(Double.valueOf(valor));
        carrinhoDAO.alterar(carrinho);
        cancelar(request, response);
    }
      private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        carrinho.setIdCar(Integer.valueOf(idCar));
        carrinho.getSkin().setIdSkin(Integer.valueOf(skinCar));
        carrinho.setValor(Double.valueOf(valor));
        carrinhoDAO.excluir(carrinho);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idCar", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("skinCar", "");
        request.setAttribute("valor", "");

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       
        List<Skin> skins = skinDAO.buscarTodas();
        request.setAttribute("skins", skins);
        
        List<Carrinho> carrinhos = carrinhoDAO.buscarTodas();
        request.setAttribute("carrinhos", carrinhos);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCarrinho.jsp");
        dispatcher.forward(request, response);

    }
    
     public void validaCampos() {
        if (skinCar == null || skinCar.isEmpty()
                || valor == null || valor.isEmpty()
               
                
                ) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes.");
        }
    }
}
