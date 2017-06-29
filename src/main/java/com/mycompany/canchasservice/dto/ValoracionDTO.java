/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dto;

/**
 *
 * @author Alejandro
 */
public class ValoracionDTO {
    
    private int valor, idCancha;
    private String nombreUsuario;
    private String comentario;
    
    public ValoracionDTO(){}

    public ValoracionDTO(int valor, String nombreUsuario, String comentario) {
        this.valor = valor;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
    }

    public ValoracionDTO(int valor, int idCancha, String usuario,
            String comentario) {
        this.valor = valor;
        this.idCancha = idCancha;
        this.comentario = comentario;
        this.nombreUsuario = usuario;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getIdCancha() {
        return idCancha;
    }
    
    
    
    
}
