/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.EstadoPrestamo;
import com.bibliotecaFUSMbackend.jpa.sessions.EstadoPrestamoSession;
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
@Path("estadoprestamos")
public class EstadoPrestamoRest {

    @EJB
    EstadoPrestamoSession estadoPrestamoSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(EstadoPrestamo estadoPrestamo) {
        estadoPrestamoSession.create(estadoPrestamo);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, EstadoPrestamo estadoPrestamo) {
        estadoPrestamoSession.update(estadoPrestamo);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        estadoPrestamoSession.remove(estadoPrestamoSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EstadoPrestamo> findAll() {
        return estadoPrestamoSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EstadoPrestamo findById(@PathParam("id") Integer id) {
        return estadoPrestamoSession.find(id);
    }
}
