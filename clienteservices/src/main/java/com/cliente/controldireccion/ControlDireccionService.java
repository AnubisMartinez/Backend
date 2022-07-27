package com.cliente.controldireccion;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ControlDireccionService {

    @Inject
    private ControlDireccionRepository repository;


    /**
     * 
     * @param idcliente
     * @return
     * @throws Exception
     */
    public List<TcsDireccion> getDireccion(Integer idcliente) throws Exception{
        try {
            if(idcliente == null){
                throw new Exception("El idcliente es obligatorio");
            }
            return repository.getDireccion(idcliente);
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
    public TcsDireccion obtenerDireccion(Integer id) throws Exception {
        try {
            if(id == null){
                throw new Exception("El id es obligatorio");
            }
            return repository.obtenerDireccion(id);
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
    public TcsDireccion guardarDireccion(TcsDireccion object) throws Exception {
        try {
            if(object == null){
                throw new Exception("El objeto es obligatorio");
            }
            return repository.guardarDireccion(object);
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
    public TcsDireccion actualizarDireccion(TcsDireccion object) throws Exception {
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
