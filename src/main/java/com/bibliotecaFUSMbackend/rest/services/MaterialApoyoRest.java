/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.MaterialApoyo;
import com.bibliotecaFUSMbackend.jpa.sessions.MaterialApoyoSession;
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
@Path("materialesapoyo")
public class MaterialApoyoRest {

    @EJB
    MaterialApoyoSession materialApoyoSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(MaterialApoyo materialApoyo) {
        materialApoyoSession.create(materialApoyo);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, MaterialApoyo materialApoyo) {
        materialApoyoSession.update(materialApoyo);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        materialApoyoSession.remove(materialApoyoSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MaterialApoyo> findAll() {
        return materialApoyoSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MaterialApoyo findById(@PathParam("id") Integer id) {
        return materialApoyoSession.find(id);
    }
}
