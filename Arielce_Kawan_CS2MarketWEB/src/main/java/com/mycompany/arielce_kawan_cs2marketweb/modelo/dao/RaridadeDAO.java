/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Raridade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author ariel
 */
public class RaridadeDAO extends GenericoDAO<Raridade>{
    
     public void salvar(Raridade r){
        String insert = "INSERT INTO raridade(raridade) VALUES (?)";
        save(insert, r.getNomeRar());
    }
    
    public void alterar(Raridade r){
        String update = "UPDATE raridade SET raridade=? WHERE idrar=?";
        save(update,r.getNomeRar(), r.getIdRar());
    }
    
    public void excluir(Raridade r){
        String delete="DELETE FROM raridade WHERE idrar=?";
        save(delete, r.getIdRar());
    }
    
    public Raridade buscarPorId(int idRaridade){
        String select = "SELECT * FROM raridade WHERE idrar=?";
        return buscarPorId(select, new RaridadeRowMapper(), idRaridade);
    }
    
    public List<Raridade> buscarTodas(){
         String select = "SELECT * FROM raridade";
        return buscarTodos(select, new RaridadeRowMapper());
    }
    
    public static class RaridadeRowMapper implements RowMapper<Raridade>{

        @Override
        public Raridade mapRow(ResultSet rs) throws SQLException {
            Raridade raridade = new Raridade();
            raridade.setIdRar(rs.getInt("idrar"));
            raridade.setNomeRar(rs.getString("raridade"));
            return raridade;
        }
        
    }
    
}

