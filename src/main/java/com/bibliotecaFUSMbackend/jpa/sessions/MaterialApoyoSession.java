/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.MaterialApoyo;
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
public class MaterialApoyoSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(MaterialApoyo materialApoyo) {
        entityManager.persist(materialApoyo);
    }

    public void update(MaterialApoyo materialApoyo) {
        entityManager.merge(materialApoyo);

    }

    public void remove(MaterialApoyo materialApoyo) {
        entityManager.remove(materialApoyo);

    }

    public List<MaterialApoyo> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(MaterialApoyo.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public MaterialApoyo find(int id) {

        return entityManager.find(MaterialApoyo.class, id);
    }
}
