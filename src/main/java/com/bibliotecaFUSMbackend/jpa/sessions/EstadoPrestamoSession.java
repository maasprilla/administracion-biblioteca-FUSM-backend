/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.EstadoPrestamo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Luis
 */
@Stateless
public class EstadoPrestamoSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(EstadoPrestamo estadoPrestamo) {
        entityManager.persist(estadoPrestamo);
    }

    public void update(EstadoPrestamo estadoPrestamo) {
        entityManager.merge(estadoPrestamo);

    }

    public void remove(EstadoPrestamo estadoPrestamo) {
        entityManager.remove(estadoPrestamo);

    }

    public List<EstadoPrestamo> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(EstadoPrestamo.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public EstadoPrestamo find(int id) {

        return entityManager.find(EstadoPrestamo.class, id);
    }
}
