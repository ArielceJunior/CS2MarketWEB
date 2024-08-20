/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Skin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ariel
 */
public class SkinDAO extends GenericoDAO<Skin> {
     
    public void salvar(Skin c){
        String insert = "INSERT INTO skin (nome,preco,fk_arma,fk_raridade,fk_colecao) VALUES (?,?,?,?,?)";
        save(insert, c.getNome(), c.getPreco(), c.getArmaSkin().getIdArma(),c.getRaridadeSkin().getIdRar(), c.getColecaoSkin().getIdCol());
    }
    
    public void alterar(Skin c){
        String update = "UPDATE skin SET nome=?,preco=?,fk_arma=?,fk_raridade=?,fk_colecao=? WHERE idskin=?";
        save(update,c.getNome(), c.getPreco(), c.getArmaSkin().getIdArma(),c.getRaridadeSkin().getIdRar(), c.getColecaoSkin().getIdCol(),c.getIdSkin());
    }
    
    public void excluir(Skin c){
        String delete="DELETE FROM skin WHERE idskin=?";
        save(delete, c.getIdSkin());
    }
    
    public Skin buscarPorId(int id){
        String select = "SELECT * FROM skin WHERE idskin=?";
        return buscarPorId(select, new SkinRowMapper(), id);
    }
    
    public List<Skin> buscarTodas(){
         String select = "SELECT * FROM skin";
        return buscarTodos(select, new SkinRowMapper());
    }
    
    public static class SkinRowMapper implements RowMapper<Skin>{
        ArmaDAO armaDAO = new ArmaDAO();
        RaridadeDAO raridadeDAO = new RaridadeDAO();
        ColecaoDAO colecaoDAO = new ColecaoDAO();
        @Override
        public Skin mapRow(ResultSet rs) throws SQLException {
            Skin skin = new Skin();
            skin.setIdSkin(rs.getInt("idskin"));
            skin.setNome(rs.getString("nome"));
            skin.setPreco(rs.getDouble("preco"));
            skin.setArmaSkin(armaDAO.buscarPorId(rs.getInt("fk_arma")));
            skin.setRaridadeSkin(raridadeDAO.buscarPorId(rs.getInt("fk_raridade")));
            skin.setColecaoSkin(colecaoDAO.buscarPorId(rs.getInt("fk_colecao")));
            return skin;
        }
        
    }
    
}

