/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Carrera;
import com.bibliotecaFUSMbackend.jpa.entities.Categoria;
import com.bibliotecaFUSMbackend.jpa.sessions.CategoriaSession;
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
@Path("categorias")
public class CategoriaRest {

    @EJB
    CategoriaSession categoriaSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Categoria categoria) {
        categoriaSession.create(categoria);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Categoria categoria) {
        categoriaSession.update(categoria);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        categoriaSession.remove(categoriaSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> findAll() {
        return categoriaSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria findById(@PathParam("id") Integer id) {
        return categoriaSession.find(id);
    }



}
