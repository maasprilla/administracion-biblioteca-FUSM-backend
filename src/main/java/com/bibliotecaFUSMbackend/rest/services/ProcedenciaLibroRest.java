/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.ProcedenciaLibro;
import com.bibliotecaFUSMbackend.jpa.sessions.ProcedenciaLibroSession;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis
 */
@Stateless
@Path("procedencialibros")
public class ProcedenciaLibroRest {

    @EJB
    ProcedenciaLibroSession procedenciaLibroSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ProcedenciaLibro procedenciaLibro) {
        procedenciaLibroSession.create(procedenciaLibro);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, ProcedenciaLibro procedenciaLibro) {
        procedenciaLibroSession.update(procedenciaLibro);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        procedenciaLibroSession.remove(procedenciaLibroSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcedenciaLibro> findAll() {
        return procedenciaLibroSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcedenciaLibro findById(@PathParam("id") Integer id) {
        return procedenciaLibroSession.find(id);
    }

}
