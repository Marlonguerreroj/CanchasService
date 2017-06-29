/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.rest;

import com.google.gson.Gson;
import com.mycompany.canchasservice.Fachada;
import com.mycompany.canchasservice.dto.*;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marlonguerrero
 */
@Path("/service")
public class WebService {
    
    @GET
    @Path("/usuarios")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String listarUsuarios() {
        String res = "";
        try {
            Fachada f = new Fachada();
            ArrayList<userDTO> list = f.listarUsuarios();
            Gson g = new Gson();
            res = g.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @GET
    @Path("/listarPersona/name={usuario}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String listarUsuarios(@PathParam("usuario") String usuario) {
        String res = "";
        try {
            Fachada f = new Fachada();
            userDTO list = f.listarUsuario(usuario);
            Gson g = new Gson();
            res = g.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @GET
    @Path("/canchas")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String listarCanchas() {
        String res = "";
        try {
            Fachada f = new Fachada();
            ArrayList<CanchaDTO> list = (ArrayList<CanchaDTO>) f.listarCanchas();
            Gson g = new Gson();
            res = g.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @GET
    @Path("/listarCancha/name={id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String listarCancha(@PathParam("id") String id) {
        String res = "";
        try {
            Fachada f = new Fachada();
            CanchaDTO list = f.listarCancha(id);
            Gson g = new Gson();
            res = g.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
