package com.cliente.controlcliente;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class TcsClienteDeta extends PanacheEntityBase {


    @EmbeddedId
    private TcsClienteDetaPK tcsclientedetapk;
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDateTime fechaactualizacion;
    private LocalDateTime fecharegistro;
    private Integer estado;
    
    public TcsClienteDetaPK getTcsclientedetapk() {
        return tcsclientedetapk;
    }
    public void setTcsclientedetapk(TcsClienteDetaPK tcsclientedetapk) {
        this.tcsclientedetapk = tcsclientedetapk;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LocalDateTime getFechaactualizacion() {
        return fechaactualizacion;
    }
    public void setFechaactualizacion(LocalDateTime fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }
    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }
    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    

    

   
    
    
}
