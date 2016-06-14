/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByAnioPublicacion", query = "SELECT l FROM Libro l WHERE l.anioPublicacion = :anioPublicacion"),
    @NamedQuery(name = "Libro.findByFechaEntrada", query = "SELECT l FROM Libro l WHERE l.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Libro.findByTomo", query = "SELECT l FROM Libro l WHERE l.tomo = :tomo")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libro")
    private Integer idLibro;
    @Size(max = 200)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio_publicacion")
    @Temporal(TemporalType.DATE)
    private Date anioPublicacion;
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Size(max = 45)
    @Column(name = "tomo")
    private String tomo;
    @ManyToMany(mappedBy = "libroList")
    private List<Autor> autorList;
    @ManyToMany(mappedBy = "libroList")
    private List<Categoria> categoriaList;
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne
    private Editorial idEditorial;
    @JoinColumn(name = "procedencia_libro", referencedColumnName = "procedencia_libro")
    @ManyToOne
    private ProcedenciaLibro procedenciaLibro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro")
    private List<CarreraHasLibro> carreraHasLibroList;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    @XmlTransient
    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    public ProcedenciaLibro getProcedenciaLibro() {
        return procedenciaLibro;
    }

    public void setProcedenciaLibro(ProcedenciaLibro procedenciaLibro) {
        this.procedenciaLibro = procedenciaLibro;
    }

    @XmlTransient
    public List<CarreraHasLibro> getCarreraHasLibroList() {
        return carreraHasLibroList;
    }

    public void setCarreraHasLibroList(List<CarreraHasLibro> carreraHasLibroList) {
        this.carreraHasLibroList = carreraHasLibroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bibliotecaFUSMbackend.jpa.entities.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
