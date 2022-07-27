package com.cliente.controlcliente;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ApplicationScoped
public class ControlClienteRepository {

    @Inject
    private EntityManager em;


    /**
     * 
     * @return
     * @throws Exception
     */
    public List<TcsClienteEnca> getClientes() throws Exception{
        try {
            StringBuilder jpql = new StringBuilder();
            jpql.append(" SELECT t FROM TcsClienteEnca t ");
            jpql.append(" WHERE t.estado = 0 ");
            Query query = em.createQuery(jpql.toString());

            return query.getResultList();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * 
     * @param correo
     * @return
     * @throws Exception
     */
    public TcsClienteEnca obtenerCliente(String correo) throws Exception {
        try {
            return TcsClienteEnca.findById(correo);
        } catch (Exception e) {
            throw e;
        }
        
    }

    /**
     * 
     * @param client
     * @return
     */
    public TcsClienteDeta buscarCliente(TcsClienteDetaPK client){
        return em.find(TcsClienteDeta.class, client);
    }

    /**
     * 
     * @param correo
     * @return
     */
    public TcsClienteEnca buscarCorreoCliente(String correo){
        return em.find(TcsClienteEnca.class, correo);
    }

    /**
     * 
     * @param id
     * @return
     */
    public TcsClienteEnca buscarIdCliente(Integer id){
        return em.find(TcsClienteEnca.class, id);
    }

    /**
     * 
     * @param deta
     * @param enca
     */
    public void guardar(TcsClienteDeta deta, TcsClienteEnca enca){
        em.merge(deta);
        em.merge(enca);
    }

    /**
     * 
     * @param enca
     */
    public void guardarEnca(TcsClienteEnca enca){
        em.merge(enca);
    }

    /**
     * 
     * @param deta
     */
    public void guardarDeta(TcsClienteDeta deta){
        em.merge(deta);
    }
    
}
