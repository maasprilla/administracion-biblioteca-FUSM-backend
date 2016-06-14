/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Autor;
import com.bibliotecaFUSMbackend.jpa.sessions.AutorSession;
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
@Path("autores")
public class AutorRest {

    @EJB
    AutorSession autorSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Autor autor) {
        autorSession.create(autor);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Autor autor) {
        autorSession.update(autor);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        autorSession.remove(autorSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> findAll() {
        return autorSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Autor findById(@PathParam("id") Integer id) {
        return autorSession.find(id);
    }
}
