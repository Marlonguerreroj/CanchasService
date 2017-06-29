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
public class CanchaDTO {
    
    private int id, precioHora, cantidadPersonas;
    private EstablecimientoDTO establecimiento;
    private String descripcion;

    public CanchaDTO() {
        establecimiento = new EstablecimientoDTO();
    }

    public CanchaDTO(int id, int precioHora, int cantidadPersonas, 
            EstablecimientoDTO establecimiento, String descripcion) {
        this.id = id;
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
    }
    
    public CanchaDTO(int precioHora, int cantidadPersonas, 
            EstablecimientoDTO establecimiento, String descripcion) {
        this.precioHora = precioHora;
        this.cantidadPersonas = cantidadPersonas;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
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
  
}
