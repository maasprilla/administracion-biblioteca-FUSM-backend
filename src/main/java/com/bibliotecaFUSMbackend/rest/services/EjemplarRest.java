/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Ejemplar;
import com.bibliotecaFUSMbackend.jpa.sessions.EjemplarSession;
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
@Path("ejemplares")
public class EjemplarRest {

    @EJB
    EjemplarSession ejemplarSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Ejemplar ejemplar) {
        ejemplarSession.create(ejemplar);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Ejemplar ejemplar) {
        ejemplarSession.update(ejemplar);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejemplarSession.remove(ejemplarSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ejemplar> findAll() {
        return ejemplarSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ejemplar findById(@PathParam("id") Integer id) {
        return ejemplarSession.find(id);
    }

    @GET
    @Path("disponibilidad/{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ejemplar> findByDisponibilidad(@PathParam("estado") boolean estado) {
        return ejemplarSession.findByDisponibilidad(estado);
    }

    @GET
    @Path("disponibilidadbylibro/{estado}/{idLibro}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ejemplar> findDisponibilidadByLibro(@PathParam("estado") boolean estado, @PathParam("idLibro") int idLibro) {
        return ejemplarSession.findDisponibilidadByLibro(estado, idLibro);
    }

    @GET
    @Path("libro/{idLibro}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ejemplar> findByLibro(@PathParam("idLibro") int idLibro) {
        return ejemplarSession.findByLibro(idLibro);
    }
}
