/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Rol;
import com.bibliotecaFUSMbackend.jpa.sessions.RolSession;
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
@Path("roles")
public class RolRest {

    @EJB
    RolSession rolSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Rol rol) {
        rolSession.create(rol);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Rol rol) {
        rolSession.update(rol);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        rolSession.remove(rolSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> findAll() {
        return rolSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rol findById(@PathParam("id") Integer id) {
        return rolSession.find(id);
    }
}
