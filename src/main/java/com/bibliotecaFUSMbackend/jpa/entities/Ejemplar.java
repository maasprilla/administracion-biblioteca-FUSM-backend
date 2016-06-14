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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "ejemplares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejemplar.findAll", query = "SELECT e FROM Ejemplar e"),
    @NamedQuery(name = "Ejemplar.findByIdEjemplares", query = "SELECT e FROM Ejemplar e WHERE e.idEjemplares = :idEjemplares"),
    @NamedQuery(name = "Ejemplar.findByIdLibros", query = "SELECT e FROM Ejemplar e WHERE e.idLibro.idLibro = :idLibro"),
    @NamedQuery(name = "Ejemplar.findByNumeroConsecutivo", query = "SELECT e FROM Ejemplar e WHERE e.numeroConsecutivo = :numeroConsecutivo"),
    @NamedQuery(name = "Ejemplar.findDisponibilidadByLibro", query = "SELECT e FROM Ejemplar e WHERE e.isDisponible = :isDisponible AND e.idLibro.idLibro = :idLibro"),
    @NamedQuery(name = "Ejemplar.findByIsDisponible", query = "SELECT e FROM Ejemplar e WHERE e.isDisponible = :isDisponible")})
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ejemplares")
    private Integer idEjemplares;
    @Size(max = 45)
    @Column(name = "numero_consecutivo")
    private String numeroConsecutivo;
    @Column(name = "is_disponible")
    private Boolean isDisponible;
    @ManyToMany(mappedBy = "ejemplarList")
    private List<Reserva> reservaList;
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    @ManyToOne
    private Libro idLibro;

    public Ejemplar() {
    }

    public Ejemplar(Integer idEjemplares) {
        this.idEjemplares = idEjemplares;
    }

    public Integer getIdEjemplares() {
        return idEjemplares;
    }

    public void setIdEjemplares(Integer idEjemplares) {
        this.idEjemplares = idEjemplares;
    }

    public String getNumeroConsecutivo() {
        return numeroConsecutivo;
    }

    public void setNumeroConsecutivo(String numeroConsecutivo) {
        this.numeroConsecutivo = numeroConsecutivo;
    }

    public Boolean getIsDisponible() {
        return isDisponible;
    }

    public void setIsDisponible(Boolean isDisponible) {
        this.isDisponible = isDisponible;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
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
        hash += (idEjemplares != null ? idEjemplares.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejemplar)) {
            return false;
        }
        Ejemplar other = (Ejemplar) object;
        if ((this.idEjemplares == null && other.idEjemplares != null) || (this.idEjemplares != null && !this.idEjemplares.equals(other.idEjemplares))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.Ejemplar[ idEjemplares=" + idEjemplares + " ]";
    }

}
