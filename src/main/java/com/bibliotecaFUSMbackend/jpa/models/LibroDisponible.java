/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.models;

import com.bibliotecaFUSMbackend.jpa.entities.Ejemplar;
import com.bibliotecaFUSMbackend.jpa.entities.Libro;
import java.util.List;

/**
 *
 * @author Luis
 */
public class LibroDisponible {

    private Libro libro;
    private boolean estado;
    private List<Ejemplar> ejemplarList;

    public LibroDisponible() {
    }

    public LibroDisponible(Libro libro, boolean estado) {
        this.libro = libro;
        this.estado = estado;
    }

    public LibroDisponible(Libro libro, boolean estado, List<Ejemplar> ejemplarList) {
        this.libro = libro;
        this.estado = estado;
        this.ejemplarList = ejemplarList;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

}
