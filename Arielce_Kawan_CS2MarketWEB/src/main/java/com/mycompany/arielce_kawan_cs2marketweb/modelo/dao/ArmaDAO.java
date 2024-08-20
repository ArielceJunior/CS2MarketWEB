/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Arma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author ariel
 */
public class ArmaDAO extends GenericoDAO<Arma>{
    
     public void salvar(Arma a){
        String insert = "INSERT INTO arma(arma) VALUES (?)";
        save(insert, a.getNomeArma());
    }
    
    public void alterar(Arma a){
        String update = "UPDATE arma SET arma=? WHERE idarma=?";
        save(update,a.getNomeArma(), a.getIdArma());
    }
    
    public void excluir(Arma a){
        String delete="DELETE FROM arma WHERE idarma=?";
        save(delete, a.getIdArma());
    }
    
    public Arma buscarPorId(int idArma){
        String select = "SELECT * FROM arma WHERE idarma=?";
        return buscarPorId(select, new ArmaRowMapper(), idArma);
    }
    
    public List<Arma> buscarTodas(){
         String select = "SELECT * FROM arma";
        return buscarTodos(select, new ArmaRowMapper());
    }
    
    public static class ArmaRowMapper implements RowMapper<Arma>{

        @Override
        public Arma mapRow(ResultSet rs) throws SQLException {
            Arma arma = new Arma();
            arma.setIdArma(rs.getInt("idarma"));
            arma.setNomeArma(rs.getString("arma"));
            return arma;
        }
        
    }
    
}

