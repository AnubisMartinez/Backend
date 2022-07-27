package com.cliente.controldireccion;

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

@Path("/direccion")
public class ControlDireccionResource {


    @Inject
    ControlDireccionService service;

    @Operation(summary = "Devuelve los Direccion del cliente por idcliente")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDireccion")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TcsDireccion> getDireccion(@PathParam("idcliente") Integer idcliente) throws Exception {
        try {
            return service.getDireccion(idcliente);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "Devuelve los Direccion por id")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDireccion")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TcsDireccion obtenerDireccion(@PathParam("id") Integer id) throws Exception {
        try {
            return service.obtenerDireccion(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Operation(summary = "Guarda los Direccion")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDireccion")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDireccion(TcsDireccion object) throws Exception {
        try {
            service.guardarDireccion(object);
            return Response.ok().build();

        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "Actualiza los Direccion")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDireccion")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarDireccion(TcsDireccion object) throws Exception {
        try {
            service.actualizarDireccion(object);
            return Response.ok().build();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
