/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Usuario;
import com.bibliotecaFUSMbackend.jpa.sessions.UsuarioSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author Luis
 */
@Stateless
@Path("usuarios")
public class UsuarioRest {

    @EJB
    UsuarioSession usuarioSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Usuario usuario) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (usuarioSession.findByEmail(usuario.getEmail()) == null) {
            usuarioSession.create(usuario);
            return Response.ok()
                    .entity(gson.toJson("ACEPTADO"))
                    .build();

        } else {
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(gson.toJson("el email ya se encuentra registrado"))
                    .build();

        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Usuario usuario) {
        usuarioSession.update(usuario);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        usuarioSession.remove(usuarioSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        return usuarioSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") Integer id) {
        return usuarioSession.find(id);
    }
}
