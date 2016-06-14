/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Editorial;
import com.bibliotecaFUSMbackend.jpa.sessions.EditorialSession;
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
@Path("editoriales")
public class EditorialRest {

    @EJB
    EditorialSession editorialSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Editorial editorial) {
        editorialSession.create(editorial);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Editorial editorial) {
        editorialSession.update(editorial);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        editorialSession.remove(editorialSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Editorial> findAll() {
        return editorialSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Editorial findById(@PathParam("id") Integer id) {
        return editorialSession.find(id);
    }
}
