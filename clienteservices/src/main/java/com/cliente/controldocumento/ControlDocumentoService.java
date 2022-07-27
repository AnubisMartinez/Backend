package com.cliente.controldocumento;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;

@ApplicationScoped
public class ControlDocumentoService {

    @Inject
    private ControlDocumentoRepository repository;

    public List<TcsDocumento> getDireccion(Integer idcliente) throws Exception{
        try {
            return repository.getDireccion(idcliente);
        } catch (Exception e) {
            throw e;
        }

    }

    public TcsDocumento obtenerCliente(Integer id) throws Exception {
        try {
            if(id == null){
                throw new Exception("El id es obligatorio");
            }
            return TcsDocumento.findById(id);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public TcsDocumento guardarDireccion(TcsDocumento object) throws Exception {
        try {
            if(object == null){
                throw new Exception("El objeto es obligatorio");
            }
            return repository.guardarDireccion(object);
        } catch (Exception e) {
            throw e;
        }
    }

    public TcsDocumento actualizarDireccion(TcsDocumento object) throws Exception {
        try {
            if(object == null){
                throw new Exception("El objeto es obligatorio");
            }
            return repository.actualizarDireccion(object);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
