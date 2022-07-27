package com.cliente.controldocumento;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;

@ApplicationScoped
public class ControlDocumentoService {

    @Inject
    private ControlDocumentoRepository repository;

    /**
     * 
     * @param idcliente
     * @return
     * @throws Exception
     */
    public List<TcsDocumento> getDocumento(Integer idcliente) throws Exception{
        try {
            if(idcliente == null){
                throw new Exception("El idcliente es obligatorio");
            }
            return repository.getDocumento(idcliente);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public TcsDocumento obtenerDocumento(Integer id) throws Exception {
        try {
            if(id == null){
                throw new Exception("El id es obligatorio");
            }
            return repository.obtenerDocumento(id);
        } catch (Exception e) {
            throw e;
        }
        
    }

    /**
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public TcsDocumento guardarDocumento(TcsDocumento object) throws Exception {
        try {
            if(object == null){
                throw new Exception("El objeto es obligatorio");
            }
            return repository.guardarDocumento(object);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public TcsDocumento actualizarDocumento(TcsDocumento object) throws Exception {
        try {
            if(object == null){
                throw new Exception("El objeto es obligatorio");
            }
            return repository.actualizarDocumento(object);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
