/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.dao;

import com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade.Colecao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ariel
 */
public class ColecaoDAO extends GenericoDAO<Colecao> {
   public void salvar(Colecao r){
        String insert = "INSERT INTO colecao(nome) VALUES (?)";
        save(insert, r.getNome());
    }
    
    public void alterar(Colecao r){
        String update = "UPDATE colecao SET nome=? WHERE idcol=?";
        save(update,r.getNome(), r.getIdCol());
    }
    
    public void excluir(Colecao r){
        String delete="DELETE FROM colecao WHERE idcol=?";
        save(delete, r.getIdCol());
    }
    
    public Colecao buscarPorId(int idCol){
        String select = "SELECT * FROM colecao WHERE idcol=?";
        return buscarPorId(select, new ColecaoRowMapper(), idCol);
    }
    
    public List<Colecao> buscarTodas(){
         String select = "SELECT * FROM colecao";
        return buscarTodos(select, new ColecaoRowMapper());
    }
    
    public static class ColecaoRowMapper implements RowMapper<Colecao>{

        @Override
        public Colecao mapRow(ResultSet rs) throws SQLException {
            Colecao colecao = new Colecao();
            colecao.setIdCol(rs.getInt("idcol"));
            colecao.setNome(rs.getString("nome"));
            return colecao;
        }
        
    }
    }

