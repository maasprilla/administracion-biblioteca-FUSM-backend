/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByIdAutores", query = "SELECT a FROM Autor a WHERE a.idAutores = :idAutores"),
    @NamedQuery(name = "Autor.findByNombre", query = "SELECT a FROM Autor a WHERE a.nombre = :nombre")})
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autores")
    private Integer idAutores;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "libros_has_autores", joinColumns = {
        @JoinColumn(name = "id_autores", referencedColumnName = "id_autores")}, inverseJoinColumns = {
        @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")})
    @ManyToMany
    private List<Libro> libroList;

    public Autor() {
    }

    public Autor(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public Integer getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(Integer idAutores) {
        this.idAutores = idAutores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutores != null ? idAutores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutores == null && other.idAutores != null) || (this.idAutores != null && !this.idAutores.equals(other.idAutores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.Autor[ idAutores=" + idAutores + " ]";
    }
    
}
