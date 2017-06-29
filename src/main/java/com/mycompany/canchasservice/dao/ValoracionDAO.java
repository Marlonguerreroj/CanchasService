/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dao;

import com.mycompany.canchasservice.dto.ValoracionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ValoracionDAO {
    
    private final Connection conn;
    
    public ValoracionDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ValoracionDAO() throws Exception {
        this.conn = Conexion.generarConexion();
    }
    
    public List<ValoracionDTO> listarValoraciones(int idCancha) {
        ArrayList<ValoracionDTO> valoraciones = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * "
                    + "FROM valoracion_canchas WHERE id_cancha = ?");
            stmt.setInt(1, idCancha);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ValoracionDTO dto = new ValoracionDTO();
                dto.setValor(rs.getInt("calificacion"));
                dto.setComentario(rs.getString("comentario"));
                dto.setNombreUsuario(rs.getString("usuario"));
                dto.setIdCancha(rs.getInt("id_cancha"));
                valoraciones.add(dto);
            }
        } catch (SQLException ex) {
            valoraciones = new ArrayList<>();
            ex.printStackTrace();
        } 
        return valoraciones;
    }
    
    public boolean registrarValoracion(ValoracionDTO dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO valoracion_canchas "
                    + "(calificacion, comentario, id_cancha, usuario) values (?, ?, ?, ?)");
            stmt.setInt(1, dto.getValor());
            stmt.setString(2, dto.getComentario());
            stmt.setInt(3, dto.getIdCancha());
            stmt.setString(4, dto.getNombreUsuario());
            exito = stmt.executeUpdate() > 0;
        } catch (SQLException ex){
            exito = false;
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex){}
            }                
        }
        return exito;
    }
}
