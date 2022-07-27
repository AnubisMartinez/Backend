package com.cliente.controldireccion;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ApplicationScoped
public class ControlDireccionRepository {

    @Inject
    private EntityManager em;

    public List<TcsDireccion> getDireccion() throws Exception{
        try {
            StringBuilder jpql = new StringBuilder();
            jpql.append(" SELECT t FROM TcsDireccion t ");
            Query query = em.createQuery(jpql.toString());

            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }

    }

    public TcsDireccion obtenerCliente(Integer idcliente) throws Exception {
        try {
            return TcsDireccion.findById(idcliente);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public TcsDireccion guardarDireccion(TcsDireccion object) throws Exception {
        try {
            object.persist();
            return object;
        } catch (Exception e) {
            throw e;
        }
    }

    public TcsDireccion actualizarDireccion(TcsDireccion object) throws Exception {
        try {
            object.getEntityManager().merge(object);
            return object;
        } catch (Exception e) {
            throw e;
        }
    }


}
