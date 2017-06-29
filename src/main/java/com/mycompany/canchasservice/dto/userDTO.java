/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author marlonguerrero
 */
public class userDTO {

    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("contrasena")
    @Expose
    private String contrasena;
    @SerializedName("telefono")
    @Expose
    private String telefono;

    public String getUsuario() {
        return usuario;
    }

    public userDTO() {
    }

    public userDTO(String usuario, String nombre, String email, String contrasena, String telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
