/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "estado_prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPrestamo.findAll", query = "SELECT e FROM EstadoPrestamo e"),
    @NamedQuery(name = "EstadoPrestamo.findByIdEstadoPrestamo", query = "SELECT e FROM EstadoPrestamo e WHERE e.idEstadoPrestamo = :idEstadoPrestamo"),
    @NamedQuery(name = "EstadoPrestamo.findByNombre", query = "SELECT e FROM EstadoPrestamo e WHERE e.nombre = :nombre")})
public class EstadoPrestamo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_prestamo")
    private Integer idEstadoPrestamo;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idEstadoPrestamo")
    private Collection<Prestamo> prestamoCollection;

    public EstadoPrestamo() {
    }

    public EstadoPrestamo(Integer idEstadoPrestamo) {
        this.idEstadoPrestamo = idEstadoPrestamo;
    }

    public Integer getIdEstadoPrestamo() {
        return idEstadoPrestamo;
    }

    public void setIdEstadoPrestamo(Integer idEstadoPrestamo) {
        this.idEstadoPrestamo = idEstadoPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPrestamo != null ? idEstadoPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPrestamo)) {
            return false;
        }
        EstadoPrestamo other = (EstadoPrestamo) object;
        if ((this.idEstadoPrestamo == null && other.idEstadoPrestamo != null) || (this.idEstadoPrestamo != null && !this.idEstadoPrestamo.equals(other.idEstadoPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.EstadoPrestamo[ idEstadoPrestamo=" + idEstadoPrestamo + " ]";
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }
    
}
