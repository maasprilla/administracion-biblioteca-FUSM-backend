/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.rest.services;

import com.bibliotecaFUSMbackend.jpa.entities.Carrera;
import com.bibliotecaFUSMbackend.jpa.entities.Categoria;
import com.bibliotecaFUSMbackend.jpa.entities.Ejemplar;
import com.bibliotecaFUSMbackend.jpa.entities.Libro;
import com.bibliotecaFUSMbackend.jpa.models.LibroDisponible;
import com.bibliotecaFUSMbackend.jpa.sessions.CategoriaSession;
import com.bibliotecaFUSMbackend.jpa.sessions.EjemplarSession;
import com.bibliotecaFUSMbackend.jpa.sessions.LibroSession;
import java.util.ArrayList;
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
@Path("libros")
public class LibroRest {

    @EJB
    LibroSession libroSession;

    @EJB
    EjemplarSession ejemplarSession;

    @EJB
    CategoriaSession categoriaSession;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Libro libro) {
        libroSession.create(libro);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Integer id, Libro libro) {
        libroSession.update(libro);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        libroSession.remove(libroSession.find(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> findAll() {
        return libroSession.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Libro findById(@PathParam("id") Integer id) {
        return libroSession.find(id);
    }

    @GET
    @Path("title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> findByTitle(@PathParam("title") String name) {
        return libroSession.findByName(name);
    }

    @GET
    @Path("titledisponible/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LibroDisponible> findWithDisponibilidad(@PathParam("title") String name) {
        List<Libro> libros = libroSession.findByName(name);
        List<LibroDisponible> librosDisponible = new ArrayList<>();
        for (Libro libro : libros) {
            List<Ejemplar> ejemplarIsDisponible = ejemplarSession.findDisponibilidadByLibro(true, libro.getIdLibro());
            if (ejemplarIsDisponible != null && (ejemplarIsDisponible.size() > 0)) {
                librosDisponible.add(new LibroDisponible(libro, true, ejemplarIsDisponible));
            } else {
                librosDisponible.add(new LibroDisponible(libro, false));
            }
        }
        return librosDisponible;
    }

    @GET
    @Path("disponibilidad")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LibroDisponible> findWithDisponibilidad() {
        List<Libro> libros = libroSession.findAll();
        List<LibroDisponible> librosDisponible = new ArrayList<>();
        for (Libro libro : libros) {
            List<Ejemplar> ejemplarIsDisponible = ejemplarSession.findDisponibilidadByLibro(true, libro.getIdLibro());
            if (ejemplarIsDisponible != null && (ejemplarIsDisponible.size() > 0)) {
                librosDisponible.add(new LibroDisponible(libro, true, ejemplarIsDisponible));
            } else {
                librosDisponible.add(new LibroDisponible(libro, false));
            }
        }
        return librosDisponible;
    }

//    @GET
//    @Path("disponibilidad")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<LibroDisponible> findGrupByCategory() {
//        List<Categoria> categorias = categoriaSession.findAll();
//        for (Categoria categoria : categorias) {
//            List<Libro> lista=libroSession.;
//            
//        }
//        return librosDisponible;
//    }

}
