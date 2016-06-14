/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.EstadoUsuario;
import com.bibliotecaFUSMbackend.jpa.sessions.EstadoUsuarioSession;
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
@Path("estadousuarios")
public class EstadoUsuarioRest {

    @EJB
    EstadoUsuarioSession estadoUsuarioSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(EstadoUsuario estadoUsuario) {
        estadoUsuarioSession.create(estadoUsuario);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, EstadoUsuario estadoUsuario) {
        estadoUsuarioSession.update(estadoUsuario);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        estadoUsuarioSession.remove(estadoUsuarioSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EstadoUsuario> findAll() {
        return estadoUsuarioSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EstadoUsuario findById(@PathParam("id") Integer id) {
        return estadoUsuarioSession.find(id);
    }
}
