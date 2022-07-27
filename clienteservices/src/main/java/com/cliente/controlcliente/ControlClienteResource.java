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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/cliente")
public class ControlClienteResource {

    @Inject
    private ControlClienteService service;

    @Operation(summary = "Devuelve la lista de clientes")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsClienteEnca")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TcsClienteEnca> getClientes() throws Exception {
        try {
            return service.getClientes();
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "Devuelve los por correo")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsClienteEnca")))
    @APIResponse(responseCode = "400", description = "No existe registro")
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
    
    @Operation(summary = "Guarda el cliente")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsClienteEnca")))
    @APIResponse(responseCode = "400", description = "No existe registro")
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

    @Operation(summary = "Actualiza los clientes")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsClienteDeta")))
    @APIResponse(responseCode = "400", description = "No existe registro")
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
