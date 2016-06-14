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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "materiales_apoyo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialApoyo.findAll", query = "SELECT m FROM MaterialApoyo m"),
    @NamedQuery(name = "MaterialApoyo.findByIdMaterialApoyo", query = "SELECT m FROM MaterialApoyo m WHERE m.idMaterialApoyo = :idMaterialApoyo")})
public class MaterialApoyo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_apoyo")
    private Integer idMaterialApoyo;
    @OneToMany(mappedBy = "idMaterialApoyo")
    private Collection<Reserva> reservaCollection;
    @OneToMany(mappedBy = "idMaterialApoyo")
    private Collection<Prestamo> prestamoCollection;

    public MaterialApoyo() {
    }

    public MaterialApoyo(Integer idMaterialApoyo) {
        this.idMaterialApoyo = idMaterialApoyo;
    }

    public Integer getIdMaterialApoyo() {
        return idMaterialApoyo;
    }

    public void setIdMaterialApoyo(Integer idMaterialApoyo) {
        this.idMaterialApoyo = idMaterialApoyo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialApoyo != null ? idMaterialApoyo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialApoyo)) {
            return false;
        }
        MaterialApoyo other = (MaterialApoyo) object;
        if ((this.idMaterialApoyo == null && other.idMaterialApoyo != null) || (this.idMaterialApoyo != null && !this.idMaterialApoyo.equals(other.idMaterialApoyo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.MaterialApoyo[ idMaterialApoyo=" + idMaterialApoyo + " ]";
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }
    
}
