/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arielce_kawan_cs2marketweb.modelo.entidade;

/**
 *
 * @author ariel
 */
public class Skin {
    private Integer idSkin;
    private String nome;
    private double preco;
    private Arma armaSkin = new Arma();
    private Raridade raridadeSkin = new Raridade();
    private Colecao colecaoSkin = new Colecao();

    public Integer getIdSkin() {
        return idSkin;
    }

    public void setIdSkin(Integer idSkin) {
        this.idSkin = idSkin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Arma getArmaSkin() {
        return armaSkin;
    }

    public void setArmaSkin(Arma armaSkin) {
        this.armaSkin = armaSkin;
    }

    public Raridade getRaridadeSkin() {
        return raridadeSkin;
    }

    public void setRaridadeSkin(Raridade raridadeSkin) {
        this.raridadeSkin = raridadeSkin;
    }

    public Colecao getColecaoSkin() {
        return colecaoSkin;
    }

    public void setColecaoSkin(Colecao colecaoSkin) {
        this.colecaoSkin = colecaoSkin;
    }
    


    
}
