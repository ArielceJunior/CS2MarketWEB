/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.controlador;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.ArmaDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.ColecaoDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.RaridadeDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.dao.SkinDAO;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Arma;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Colecao;
import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Raridade;
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


@WebServlet(WebConstantes.BASE_PATH + "/SkinControlador")
public class SkinControlador extends HttpServlet {
    private ArmaDAO armaDAO;
    private Arma arma;
    private RaridadeDAO raridadeDAO;
    private Raridade raridade;
    private ColecaoDAO colecaoDAO;
    private Colecao colecao;
    private SkinDAO skinDAO;
    private Skin skin;
    String idSkin = "";
    String nome = "";
    String preco = "";
    String armaSkin = "";
    String raridadeSkin = "";
    String colecaoSkin = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        armaDAO = new ArmaDAO();
        arma = new Arma();
        raridadeDAO = new RaridadeDAO();
        raridade = new Raridade();
        colecaoDAO = new ColecaoDAO();
        colecao = new Colecao();
        skinDAO = new SkinDAO();
        skin = new Skin();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            idSkin = request.getParameter("idSkin");
            nome = request.getParameter("nome");
            preco = request.getParameter("preco");
            armaSkin = request.getParameter("armaSkin");
            raridadeSkin = request.getParameter("raridadeSkin");
            colecaoSkin = request.getParameter("colecaoSkin");
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
        skin.setNome(nome);
        skin.setPreco(Double.valueOf(preco));
        skin.getArmaSkin().setIdArma(Integer.valueOf(armaSkin));
        skin.getRaridadeSkin().setIdRar(Integer.valueOf(raridadeSkin));
        skin.getColecaoSkin().setIdCol(Integer.valueOf(colecaoSkin));
        skinDAO.salvar(skin);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSkin", idSkin);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nome", nome);
        request.setAttribute("preco", preco);
        request.setAttribute("armaSkin", armaSkin);
        request.setAttribute("raridadeSkin", raridadeSkin);
        request.setAttribute("colecaoSkin", colecaoSkin);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
   private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSkin", idSkin);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nome", nome);
        request.setAttribute("preco", preco);
        request.setAttribute("armaSkin", armaSkin);
        request.setAttribute("raridadeSkin", raridadeSkin);
        request.setAttribute("colecaoSkin", colecaoSkin);
        request.setAttribute("mensagem", "Clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        skin.setIdSkin(Integer.valueOf(idSkin));
        skin.setNome(nome);
        skin.setPreco(Double.valueOf(preco));
        skin.getArmaSkin().setIdArma(Integer.valueOf(armaSkin));
        skin.getRaridadeSkin().setIdRar(Integer.valueOf(raridadeSkin));
        skin.getColecaoSkin().setIdCol(Integer.valueOf(colecaoSkin));
        skinDAO.alterar(skin);
        cancelar(request, response);
    }
      private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validaCampos();
        skin.setIdSkin(Integer.valueOf(idSkin));
        skin.setNome(nome);
        skin.setPreco(Double.valueOf(preco));
        skin.getArmaSkin().setIdArma(Integer.valueOf(armaSkin));
        skin.getRaridadeSkin().setIdRar(Integer.valueOf(raridadeSkin));
        skin.getColecaoSkin().setIdCol(Integer.valueOf(colecaoSkin));
        skinDAO.excluir(skin);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idSkin", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("nome", "");
        request.setAttribute("preco", "");
        request.setAttribute("armaSkin", "");
        request.setAttribute("raridadeSkin", "");
        request.setAttribute("colecaoSkin", "");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        List<Arma> armas = armaDAO.buscarTodas();
        request.setAttribute("armas", armas);
        
        List<Raridade> raridades = raridadeDAO.buscarTodas();
        request.setAttribute("raridades", raridades);
        
        List<Colecao> colecoes = colecaoDAO.buscarTodas();
        request.setAttribute("colecoes", colecoes);
        
        List<Skin> skins = skinDAO.buscarTodas();
        request.setAttribute("skins", skins);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroSkin.jsp");
        dispatcher.forward(request, response);

    }
    
     public void validaCampos() {
        if (nome == null || nome.isEmpty()
                || preco == null || preco.isEmpty()
                || armaSkin == null || armaSkin.isEmpty()
                || raridadeSkin == null || raridadeSkin.isEmpty()
                || colecaoSkin == null || raridadeSkin.isEmpty()
                
                ) {
            throw new IllegalArgumentException("Um ou mais parâmetros estão ausentes.");
        }
    }
}
