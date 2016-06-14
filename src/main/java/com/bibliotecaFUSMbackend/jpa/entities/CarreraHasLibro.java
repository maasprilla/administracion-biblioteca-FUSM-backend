/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "carreras_has_libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarreraHasLibro.findAll", query = "SELECT c FROM CarreraHasLibro c"),
    @NamedQuery(name = "CarreraHasLibro.findByIdCarreraHasLibro", query = "SELECT c FROM CarreraHasLibro c WHERE c.idCarreraHasLibro = :idCarreraHasLibro")})
public class CarreraHasLibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrera_has_libro")
    private Integer idCarreraHasLibro;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne(optional = false)
    private Carrera idCarrera;
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    @ManyToOne(optional = false)
    private Libro idLibro;

    public CarreraHasLibro() {
    }

    public CarreraHasLibro(Integer idCarreraHasLibro) {
        this.idCarreraHasLibro = idCarreraHasLibro;
    }

    public Integer getIdCarreraHasLibro() {
        return idCarreraHasLibro;
    }

    public void setIdCarreraHasLibro(Integer idCarreraHasLibro) {
        this.idCarreraHasLibro = idCarreraHasLibro;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarreraHasLibro != null ? idCarreraHasLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarreraHasLibro)) {
            return false;
        }
        CarreraHasLibro other = (CarreraHasLibro) object;
        if ((this.idCarreraHasLibro == null && other.idCarreraHasLibro != null) || (this.idCarreraHasLibro != null && !this.idCarreraHasLibro.equals(other.idCarreraHasLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.CarreraHasLibro[ idCarreraHasLibro=" + idCarreraHasLibro + " ]";
    }
    
}
