/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Carrera;
import com.bibliotecaFUSMbackend.jpa.entities.Libro;
import com.bibliotecaFUSMbackend.jpa.models.LibroDisponible;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
@Stateless
public class LibroSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Libro libro) {
        entityManager.persist(libro);
    }

    public void update(Libro libro) {
        entityManager.merge(libro);

    }

    public void remove(Libro libro) {
        entityManager.remove(libro);

    }

    public List<Libro> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Libro.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Libro find(int id) {

        return entityManager.find(Libro.class, id);
    }

    public List<Libro> findByName(String name) {
        try {
            return (List<Libro>) entityManager.createNamedQuery("Libro.findByTitulo")
                    .setParameter("titulo", name + "%")
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    
//    public List<Libro> findByName(int idCategoria) {
//        try {
//            return (List<Libro>) entityManager.createNamedQuery("Libro.")
//                    .setParameter("titulo", name + "%")
//                    .getResultList();
//        } catch (NonUniqueResultException ex) {
//            throw ex;
//        } catch (NoResultException ex) {
//            return null;
//        }
//    }

}
