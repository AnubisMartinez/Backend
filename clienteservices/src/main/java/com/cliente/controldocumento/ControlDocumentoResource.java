package com.cliente.controldocumento;

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

@Path("/documento")
public class ControlDocumentoResource {


    @Inject
    ControlDocumentoService service;

    @Operation(summary = "Devuelve los documentos del cliente por idcliente")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDocumento")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TcsDocumento> getDocumento(@PathParam("idcliente") Integer idcliente) throws Exception {
        try {
            return service.getDocumento(idcliente);
        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "Devuelve los documentos por id")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDocumento")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TcsDocumento obtenerDocumenton(@PathParam("id") Integer id) throws Exception {
        try {
            return service.obtenerDocumento(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Operation(summary = "Guarda los documento")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDocumento")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarDocumenton(TcsDocumento object) throws Exception {
        try {
            service.guardarDocumento(object);
            return Response.ok().build();

        } catch (Exception e) {
            throw e;
        }
    }

    @Operation(summary = "Actualiza los documwntos")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                schema = @Schema(example = "TcsDocumento")))
    @APIResponse(responseCode = "400", description = "No existe registro")
    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarDocumento(TcsDocumento object) throws Exception {
        try {
            service.actualizarDocumento(object);
            return Response.ok().build();

        } catch (Exception e) {
            throw e;
        }
    }

    
    
}
