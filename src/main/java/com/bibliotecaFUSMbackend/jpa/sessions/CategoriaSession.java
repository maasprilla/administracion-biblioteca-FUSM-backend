/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Categoria;
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
public class CategoriaSession {

   @PersistenceContext
    private EntityManager entityManager;

    public void create(Categoria categoria) {
        entityManager.persist(categoria);
    }

    public void update(Categoria categoria) {
        entityManager.merge(categoria);

    }

    public void remove(Categoria categoria) {
        entityManager.remove(categoria);

    }

    public List<Categoria> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Categoria.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Categoria find(int id) {

        return entityManager.find(Categoria.class, id);
    }
}
