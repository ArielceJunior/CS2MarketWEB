package com.mycompany.arielce_kawan_cs2marketweb.controlador;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.WishlistDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Wishlist;
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
@WebServlet(WebConstantes.BASE_PATH + "/WishlistControlador")
public class WishlistControlador extends HttpServlet {

    private WishlistDAO wishlistDAO;
    private Wishlist wishlist;
    String idWish = "";
    String wishUser = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        wishlistDAO = new WishlistDAO();
        wishlist = new Wishlist();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idWish = request.getParameter("idWish");
            wishUser = request.getParameter("wishUser")
            ;
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            switch (opcao) {
                case "cadastrar":  cadastrar(request, response); break;
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
        wishlist.getWishUser().setUsername(wishUser);
        wishlistDAO.salvar(wishlist);
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idWish", idWish);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("wishUser", wishUser);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusão dos dados");
        encaminharParaPagina(request, response);
    }

    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        wishlist.setIdWish(Integer.valueOf(idWish));
         wishlist.getWishUser().setUsername(wishUser);
        wishlistDAO.excluir(wishlist);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idWish", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("wishUser", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Wishlist> colecoes = wishlistDAO.buscarTodas();
        request.setAttribute("colecoes", colecoes);
        request.setAttribute(opcao, opcao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroWishlist.jsp");
        dispatcher.forward(request, response);

    }
    
    public void validaCampos(){
        if(wishUser==null || wishUser.isEmpty()){
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes");
        }
    }

}
