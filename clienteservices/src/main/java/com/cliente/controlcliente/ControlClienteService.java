package com.cliente.controlcliente;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ControlClienteService {

    @Inject
    private ControlClienteRepository repository;

    public List<TcsClienteEnca> getClientes() throws Exception {
        try {
            return repository.getClientes();
        } catch (Exception e) {
            throw e;
        }
    }

    public TcsClienteEnca obtenerCliente(String correo) throws Exception {
        try {
            if(correo == null || correo.trim().equals("")){
                throw new Exception("El correo es obligatorio");
            } else {
                return repository.obtenerCliente(correo);
            }
            
        } catch (Exception e) {
            throw e;
        }
    }

    public String guardarCliente (TcsClienteEnca en) throws Exception {
        try {
            if(en == null){
                return "null";
            }
            TcsClienteEnca enca = repository.buscarCorreoCliente(en.getCorreo());
            if(enca != null){
                return "false";
            } else {  
                en.setFecharegistro(LocalDateTime.now());   
                repository.guardarEnca(en);
                return "true";
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public String EditarCliente (TcsClienteDeta td) throws Exception {
        try {
            if(td == null){
                return "null";
            }
            TcsClienteDeta deta = repository.buscarCliente(td.getTcsclientedetapk());
            if(deta == null){
                TcsClienteEnca enca = repository.buscarCorreoCliente(td.getTcsclientedetapk().getCorreo());
                //Tabla enca
                enca.setId(td.getTcsclientedetapk().getId());
                enca.setNombre(td.getNombre());
                enca.setApellido(td.getApellido());
                enca.setCorreo(td.getTcsclientedetapk().getCorreo().toLowerCase());
                enca.setTelefono(td.getTelefono());
                enca.setFecharegistro(enca.getFecharegistro());
                enca.setFechaactualizacion(LocalDateTime.now());
                enca.setEstado(td.getEstado());
                //Tabla deta
                enca.setCorreo(td.getTcsclientedetapk().getCorreo().toLowerCase());
                td.getTcsclientedetapk().setId(enca.getId());
                td.setFechaactualizacion(LocalDateTime.now());
                td.setFecharegistro(enca.getFecharegistro());
                td.setEstado(td.getEstado());
                repository.guardar(td, enca);
            }
 
            return "true";
        } catch (Exception e) {
            throw e;
        }
    }


    
}
