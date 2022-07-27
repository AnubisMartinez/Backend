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

    /**
     * 
     * @param idcliente
     * @return
     * @throws Exception
     */
    public List<TcsDireccion> getDireccion(Integer idcliente) throws Exception{
        try {
            StringBuilder jpql = new StringBuilder();
            jpql.append(" SELECT t FROM TcsDireccion t ");
            jpql.append(" WHERE t.idcliente = :idcliente ");
            jpql.append(" AND t.estado = 0 ");
            Query query = em.createQuery(jpql.toString());

            return query.getResultList();
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
            return TcsDireccion.findById(id);
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
            object.persist();
            return object;
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
            object.getEntityManager().merge(object);
            return object;
        } catch (Exception e) {
            throw e;
        }
    }


}
