/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Ejemplar;
import com.bibliotecaFUSMbackend.jpa.entities.Reserva;
import com.bibliotecaFUSMbackend.jpa.entities.Usuario;
import com.bibliotecaFUSMbackend.jpa.sessions.EjemplarSession;
import com.bibliotecaFUSMbackend.jpa.sessions.ReservaSession;
import com.bibliotecaFUSMbackend.rest.auth.AuthUtils;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis
 */
@Stateless
@Path("reservas")
public class ReservaRest {

    @EJB
    ReservaSession reservaSession;

    @EJB
    EjemplarSession ejemplarSession;

    @Context
    private HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Reserva reserva) {

        List<Ejemplar> list = new ArrayList<>();
        for (Ejemplar ejemplar : reserva.getEjemplarList()) {
            if (ejemplar != null && ejemplar.getIdEjemplares() != null) {
                list.add(ejemplar);
            }
        }
        reserva.setEjemplarList(list);

        try {
            String a = AuthUtils.getSubject(
                    request.getHeader(AuthUtils.AUTH_HEADER_KEY));
            reserva.setIdUsuario(
                    new Usuario(
                            Integer.parseInt(
                                    AuthUtils.getSubject(
                                            request.getHeader(AuthUtils.AUTH_HEADER_KEY)))));
            reservaSession.create(reserva);
        } catch (ParseException | JOSEException ex) {
            Logger.getLogger(ReservaRest.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Ejemplar> lista = reserva.getEjemplarList();
        for (Ejemplar ejemplar : lista) {
            ejemplar.setIsDisponible(false);
            ejemplarSession.update(ejemplar);

        }

        reservaSession.create(reserva);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Reserva reserva) {
        reservaSession.update(reserva);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        reservaSession.remove(reservaSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> findAll() {
        return reservaSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva findById(@PathParam("id") Integer id) {
        return reservaSession.find(id);
    }
}
