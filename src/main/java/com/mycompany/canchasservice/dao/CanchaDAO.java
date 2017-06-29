/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.mycompany.canchasservice.dto.CanchaDTO;
import com.mycompany.canchasservice.dto.EstablecimientoDTO;
import com.mycompany.canchasservice.dto.ValoracionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class CanchaDAO {
    
    private final Connection conn;
    
    public CanchaDAO() throws Exception {
        conn = Conexion.generarConexion();
    }
    
    public List<CanchaDTO> listarCanchas() {
        ArrayList<CanchaDTO> canchas = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT c.*, e.* FROM canchas "
                    + "c JOIN establecimientos e ON c.id_establecimiento = e.id_est");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                CanchaDTO dto = new CanchaDTO();
                dto.setId(rs.getInt("id_cancha"));
                dto.setDescripcion(rs.getString("descripcion_cancha"));
                dto.setPrecioHora(rs.getInt("precio_hora"));
                dto.setCantidadPersonas(rs.getInt("cantidad_personas"));
                EstablecimientoDTO est = new EstablecimientoDTO();
                est.setId(rs.getInt("id_est"));
                est.setNombre(rs.getString("nombre"));
                est.setDireccion(rs.getString("direccion"));
                est.setCiudad(rs.getString("ciudad"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setTelefono(rs.getString("telefono"));
                est.setEmail(rs.getString("email"));
                dto.setEstablecimiento(est);
                ValoracionDAO dao = new ValoracionDAO(conn);
                dto.setValoraciones((ArrayList<ValoracionDTO>) dao.listarValoraciones(dto.getId()));
                canchas.add(dto);
            }
        } catch (Exception ex) {
            canchas = new ArrayList<>();
            ex.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex){}
            }
        }
        return canchas;
    }
    
    public CanchaDTO listarCancha(String id) {
        CanchaDTO cancha = new CanchaDTO();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT c.*, e.* FROM canchas "
                    + "c JOIN establecimientos e ON c.id_establecimiento = e.id_est "
                    + "WHERE c.id_cancha = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                cancha.setId(rs.getInt("id_cancha"));
                cancha.setDescripcion(rs.getString("descripcion_cancha"));
                cancha.setPrecioHora(rs.getInt("precio_hora"));
                cancha.setCantidadPersonas(rs.getInt("cantidad_personas"));
                EstablecimientoDTO est = new EstablecimientoDTO();
                est.setId(rs.getInt("id_est"));
                est.setNombre(rs.getString("nombre"));
                est.setDireccion(rs.getString("direccion"));
                est.setCiudad(rs.getString("ciudad"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setTelefono(rs.getString("telefono"));
                est.setEmail(rs.getString("email"));
                cancha.setEstablecimiento(est);
                ValoracionDAO dao = new ValoracionDAO(conn);
                cancha.setValoraciones((ArrayList<ValoracionDTO>) dao.listarValoraciones(cancha.getId()));
            }
        } catch (Exception ex) {
            cancha = new CanchaDTO();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex){}
            }
        }
        return cancha;
    }
}
