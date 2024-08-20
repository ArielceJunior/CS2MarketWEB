/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Wishlist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ariel
 */
public class WishlistDAO extends GenericoDAO<Wishlist>{
    public void salvar(Wishlist c){
        String insert = "INSERT INTO wishlist (iduser) VALUES (?)";
        save(insert, c.getWishUser());
    }
    public void excluir(Wishlist c){
        String delete="DELETE FROM wishlist WHERE id=?";
        save(delete, c.getIdWish());
    }
    
    public Wishlist buscarPorId(int id){
        String select = "SELECT * FROM wishlist WHERE id=?";
        return buscarPorId(select, new WishlistRowMapper(), id);
    }
    
    public List<Wishlist> buscarTodas(){
         String select = "SELECT * FROM wishlist";
        return buscarTodos(select, new WishlistRowMapper());
    }
    
    public static class WishlistRowMapper implements RowMapper<Wishlist>{
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        @Override
        public Wishlist mapRow(ResultSet rs) throws SQLException {
            Wishlist wish = new Wishlist();
            wish.setIdWish(rs.getInt("id"));
            wish.setWishUser(usuarioDAO.getUserByUsername("username"));
            
            return wish;
        }
        
    }
}
