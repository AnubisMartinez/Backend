package com.cliente.controlcliente;

import java.util.List;



import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ControlClienteResource {

    @Inject
    private ControlClienteService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TcsClienteEnca> getClientes() throws Exception {
        try {
            return service.getClientes();
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    @Path("correo/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public TcsClienteEnca obtenerCliente(@PathParam("correo") String correo) throws Exception {
        try {
            return service.obtenerCliente(correo);
        } catch (Exception e) {
            throw e;
        }
    }
    

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarCliente(TcsClienteEnca en) throws Exception {
        try {
            String generate = service.guardarCliente(en);
            return Response.ok(generate, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            throw e;
        }
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response EditarCliente(TcsClienteDeta td) throws Exception {
        try {
            String generate = service.EditarCliente(td);
            return Response.ok(generate, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            throw e;
        }
    }

}
