/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Editorial;
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
public class EditorialSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Editorial editorial) {
        entityManager.persist(editorial);
    }

    public void update(Editorial editorial) {
        entityManager.merge(editorial);

    }

    public void remove(Editorial editorial) {
        entityManager.remove(editorial);

    }

    public List<Editorial> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Editorial.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Editorial find(int id) {

        return entityManager.find(Editorial.class, id);
    }
}
