/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Carrera;
import com.bibliotecaFUSMbackend.jpa.sessions.CarreraSession;
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
@Path("carreras")
public class CarreraRest {

    @EJB
    CarreraSession carreraSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Carrera carrera) {
        carreraSession.create(carrera);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Carrera carrera) {
        carreraSession.update(carrera);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        carreraSession.remove(carreraSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carrera> findAll() {
        return carreraSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrera findById(@PathParam("id") Integer id) {
        return carreraSession.find(id);
    }

    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carrera> findByname(@PathParam("name") String name) {
        return carreraSession.findByName(name);
    }
}
