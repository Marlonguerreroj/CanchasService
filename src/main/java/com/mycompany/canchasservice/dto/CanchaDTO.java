/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.canchasservice.dto;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class CanchaDTO {
    
    private int id, precioHora, cantidadPersonas, valoracionGeneral;
    private EstablecimientoDTO establecimiento;
    private String descripcion;
    private ArrayList<ValoracionDTO> valoraciones;

    public CanchaDTO() {
        establecimiento = new EstablecimientoDTO();
        valoraciones = new ArrayList<>();
        valoracionGeneral = 0;
    }

    public CanchaDTO(int id, int precioHora, int cantidadPersonas, 
            EstablecimientoDTO establecimiento, String descripcion) {
        this.id = id;
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
        valoraciones = new ArrayList<>();
        valoracionGeneral = 0;
    }
    
    public CanchaDTO(int precioHora, int cantidadPersonas, 
            EstablecimientoDTO establecimiento, String descripcion) {
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
        valoraciones = new ArrayList<>();
        valoracionGeneral = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public EstablecimientoDTO getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(EstablecimientoDTO establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValoraciones(ArrayList<ValoracionDTO> valoraciones) {
        this.valoraciones = valoraciones;
        for(int i = 0; i < valoraciones.size(); i++) {
            valoracionGeneral += valoraciones.get(i).getValor();
        }
        if(valoraciones.size() > 0)
            valoracionGeneral /= valoraciones.size();
    }

    public ArrayList<ValoracionDTO> getValoraciones() {
        return valoraciones;
    }

    public void setValoracionGeneral(int valoracionGeneral) {
        this.valoracionGeneral = valoracionGeneral;
    }

    public int getValoracionGeneral() {
        return valoracionGeneral;
    }
    
}
