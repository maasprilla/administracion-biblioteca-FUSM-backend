/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "procedencia_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedenciaLibro.findAll", query = "SELECT p FROM ProcedenciaLibro p"),
    @NamedQuery(name = "ProcedenciaLibro.findByProcedenciaLibro", query = "SELECT p FROM ProcedenciaLibro p WHERE p.procedenciaLibro = :procedenciaLibro"),
    @NamedQuery(name = "ProcedenciaLibro.findByNombre", query = "SELECT p FROM ProcedenciaLibro p WHERE p.nombre = :nombre")})
public class ProcedenciaLibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "procedencia_libro")
    private Integer procedenciaLibro;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaLibro")
    private List<Libro> libroList;

    public ProcedenciaLibro() {
    }

    public ProcedenciaLibro(Integer procedenciaLibro) {
        this.procedenciaLibro = procedenciaLibro;
    }

    public Integer getProcedenciaLibro() {
        return procedenciaLibro;
    }

    public void setProcedenciaLibro(Integer procedenciaLibro) {
        this.procedenciaLibro = procedenciaLibro;
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
        hash += (procedenciaLibro != null ? procedenciaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedenciaLibro)) {
            return false;
        }
        ProcedenciaLibro other = (ProcedenciaLibro) object;
        if ((this.procedenciaLibro == null && other.procedenciaLibro != null) || (this.procedenciaLibro != null && !this.procedenciaLibro.equals(other.procedenciaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.ProcedenciaLibro[ procedenciaLibro=" + procedenciaLibro + " ]";
    }
    
}
