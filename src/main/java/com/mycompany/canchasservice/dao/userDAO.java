/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dao;

import com.mycompany.canchasservice.dto.userDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marlonguerrero
 */
public class userDAO {
    private Connection conn;
    
    public ArrayList<userDTO> listarPersonas() throws Exception {
        ArrayList<userDTO> list = new ArrayList<>();
        conn = Conexion.generarConexion();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users"
                + "");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            userDTO rel = new userDTO();
            
            rel.setUsuario(rs.getString(1));
            rel.setNombre(rs.getString(2));
            rel.setEmail(rs.getString(3));
            rel.setContrasena(rs.getString(4));
            rel.setTelefono(rs.getString(5));
            list.add(rel);
        }
        return list;
    }
    public userDTO listarPersona(String usuario) throws Exception {
        userDTO rel = new userDTO();
        conn = Conexion.generarConexion();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users where usuario = ?"
                + "");
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            rel = new userDTO();
            rel.setUsuario(rs.getString(1));
            rel.setNombre(rs.getString(2));
            rel.setEmail(rs.getString(3));
            rel.setContrasena(rs.getString(4));
            rel.setTelefono(rs.getString(5));
        }
        return rel;
    }
    
    public boolean registrarPersona(userDTO dto) throws Exception {
        boolean exito = false;
        conn = Conexion.generarConexion();
        if (conn != null) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users"
                    + " (usuario, nombre, email,contrasena,telefono) values (?,?,?,?,?)");
            stmt.setString(1, dto.getUsuario());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getEmail());
            stmt.setString(4, dto.getContrasena());
            stmt.setString(5, dto.getTelefono());
            
            try {
                exito = stmt.executeUpdate() > 0;
            } catch (SQLException ex) {
            } finally {
                conn.close();
                stmt.close();
            }
        }
        return exito;
    }
}
