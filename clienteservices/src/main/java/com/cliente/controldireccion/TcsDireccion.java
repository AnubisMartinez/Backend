package com.cliente.controldireccion;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class TcsDireccion extends PanacheEntityBase{

    @Id
    private Integer id;
    private Integer idcliente;
    private String departamento;
    private String municipio;
    private LocalDateTime fecharegistro;
    private LocalDateTime fechaactualizacion;
    private Integer estado;


    public Integer getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public LocalDateTime getFecharegistro() {
        return fecharegistro;
    }
    public void setFecharegistro(LocalDateTime fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public LocalDateTime getFechaactualizacion() {
        return fechaactualizacion;
    }
    public void setFechaactualizacion(LocalDateTime fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }
    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    

}
