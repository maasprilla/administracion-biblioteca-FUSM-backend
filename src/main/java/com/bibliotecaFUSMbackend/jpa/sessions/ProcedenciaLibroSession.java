/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.ProcedenciaLibro;
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
public class ProcedenciaLibroSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(ProcedenciaLibro procedenciaLibro) {
        entityManager.persist(procedenciaLibro);
    }

    public void update(ProcedenciaLibro procedenciaLibro) {
        entityManager.merge(procedenciaLibro);

    }

    public void remove(ProcedenciaLibro procedenciaLibro) {
        entityManager.remove(procedenciaLibro);

    }

    public List<ProcedenciaLibro> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ProcedenciaLibro.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public ProcedenciaLibro find(int id) {

        return entityManager.find(ProcedenciaLibro.class, id);
    }
}
