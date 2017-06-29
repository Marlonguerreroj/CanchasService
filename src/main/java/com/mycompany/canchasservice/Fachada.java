/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice;

import com.mycompany.canchasservice.dao.*;
import com.mycompany.canchasservice.dto.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlonguerrero
 */
public class Fachada {
    public ArrayList<userDTO> listarUsuarios() throws Exception {
        userDAO a = new userDAO();
        return a.listarPersonas();
    }
    public userDTO listarUsuario(String usuario) throws Exception {
        userDAO a = new userDAO();
        return a.listarPersona(usuario);
    }
    
    public List<CanchaDTO> listarCanchas() throws Exception {
        CanchaDAO a = new CanchaDAO();
        return a.listarCanchas();
    }
    public CanchaDTO listarCancha(String id) throws Exception {
        CanchaDAO a = new CanchaDAO();
        return a.listarCancha(id);
    }
    
    public boolean registrarUsuario (String usuario,String nombre,String email,
            String contrasena, String telefono)throws Exception{
        userDAO dao =new userDAO();
        userDTO dto = new userDTO(usuario, nombre, email, contrasena, telefono);
        return dao.registrarPersona(dto);
    }
    
}
