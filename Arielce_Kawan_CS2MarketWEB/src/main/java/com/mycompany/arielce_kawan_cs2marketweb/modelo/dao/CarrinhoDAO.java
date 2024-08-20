/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Carrinho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ariel
 */
public class CarrinhoDAO extends GenericoDAO<Carrinho> {
    
    public void salvar(Carrinho c){
        String insert = "INSERT INTO carrinho (id_skin, valor) VALUES (?,?,?)";
        save(insert, c.getSkin().getIdSkin(), c.getValor());
    }
    
    public void alterar(Carrinho c){
        String update = "UPDATE carrinho SET id_skin=?, valor=? WHERE idcarrinho=?";
        save(update,  c.getSkin().getIdSkin(), c.getValor());
    }
    
    public void excluir(Carrinho c){
        String delete="DELETE FROM carrinho WHERE idcarrinho=?";
        save(delete, c.getIdCar());
    }
    
    public Carrinho buscarPorId(int id){
        String select = "SELECT * FROM carrinho WHERE idcarrinho=?";
        return buscarPorId(select, new CarrinhoRowMapper(), id);
    }
    

    
    
    public List<Carrinho> buscarTodas(){
         String select = "SELECT * FROM carrinho";
        return buscarTodos(select, new CarrinhoRowMapper());
    }
    
    public static class CarrinhoRowMapper implements RowMapper<Carrinho>{
        SkinDAO skinDAO = new SkinDAO();
        @Override
        public Carrinho mapRow(ResultSet rs) throws SQLException {
            Carrinho carrinho = new Carrinho();
            carrinho.setIdCar(rs.getInt("idcarrinho"));
            carrinho.setSkin(skinDAO.buscarPorId(rs.getInt("id_skin")));
            carrinho.setValor(rs.getDouble("valor"));
            return carrinho;
        }
        
    }
}
