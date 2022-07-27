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

    public TcsClienteEnca obtenerCliente(String correo) throws Exception {
        try {
            return TcsClienteEnca.findById(correo);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public TcsClienteDeta buscarCliente(TcsClienteDetaPK client){
        return em.find(TcsClienteDeta.class, client);
    }

    public TcsClienteEnca buscarCorreoCliente(String correo){
        return em.find(TcsClienteEnca.class, correo);
    }

    public TcsClienteEnca buscarIdCliente(Integer id){
        return em.find(TcsClienteEnca.class, id);
    }

    public void guardar(TcsClienteDeta deta, TcsClienteEnca enca){
        em.merge(deta);
        em.merge(enca);
    }

    public void guardarEnca(TcsClienteEnca enca){
        em.merge(enca);
    }

    public void guardarDeta(TcsClienteDeta deta){
        em.merge(deta);
    }
    
}
