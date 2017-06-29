/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice;

import com.mycompany.canchasservice.dao.userDAO;
import com.mycompany.canchasservice.dto.userDTO;
import java.util.ArrayList;

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

}
