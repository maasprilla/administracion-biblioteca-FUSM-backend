/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Autor;
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
public class AutorSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Autor autor) {
        entityManager.persist(autor);
    }

    public void update(Autor autor) {
        entityManager.merge(autor);

    }

    public void remove(Autor autor) {
        entityManager.remove(autor);

    }

    public List<Autor> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Autor.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Autor find(int id) {

        return entityManager.find(Autor.class, id);
    }
}
