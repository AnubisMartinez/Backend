package com.cliente.controlcliente;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TcsClienteDetaPK implements Serializable {


    private String correo;
    
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

}
