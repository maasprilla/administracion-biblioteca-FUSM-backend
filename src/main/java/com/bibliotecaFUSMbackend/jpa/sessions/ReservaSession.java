/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Reserva;
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
public class ReservaSession {

   @PersistenceContext
    private EntityManager entityManager;

    public void create(Reserva reserva) {
        entityManager.persist(reserva);
    }

    public void update(Reserva reserva) {
        entityManager.merge(reserva);

    }

    public void remove(Reserva reserva) {
        entityManager.remove(reserva);

    }

    public List<Reserva> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Reserva.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Reserva find(int id) {

        return entityManager.find(Reserva.class, id);
    }
}
