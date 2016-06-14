/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Ejemplar;
import com.bibliotecaFUSMbackend.jpa.entities.Libro;
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
public class EjemplarSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Ejemplar ejemplar) {
        entityManager.persist(ejemplar);
    }

    public void update(Ejemplar ejemplar) {
        entityManager.merge(ejemplar);

    }

    public void remove(Ejemplar ejemplar) {
        entityManager.remove(ejemplar);

    }

    public List<Ejemplar> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ejemplar.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Ejemplar find(int id) {

        return entityManager.find(Ejemplar.class, id);
    }

    public List<Ejemplar> findByDisponibilidad(boolean estado) {
        try {
            return (List<Ejemplar>) entityManager.createNamedQuery("Ejemplar.findByIsDisponible")
                    .setParameter("isDisponible", estado)
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Ejemplar> findDisponibilidadByLibro(boolean estado, int idLibro) {
        try {
            return (List<Ejemplar>) entityManager.createNamedQuery("Ejemplar.findDisponibilidadByLibro")
                    .setParameter("isDisponible", estado)
                    .setParameter("idLibro", idLibro)
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Ejemplar> findByLibro(int idLibro) {
        try {
            return (List<Ejemplar>) entityManager.createNamedQuery("Ejemplar.findByIdLibros")
                    .setParameter("idLibro", idLibro)
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
