/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.EstadoUsuario;
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
public class EstadoUsuarioSession {

   @PersistenceContext
    private EntityManager entityManager;

    public void create(EstadoUsuario estadoUsuario) {
        entityManager.persist(estadoUsuario);
    }

    public void update(EstadoUsuario estadoUsuario) {
        entityManager.merge(estadoUsuario);

    }

    public void remove(EstadoUsuario estadoUsuario) {
        entityManager.remove(estadoUsuario);

    }

    public List<EstadoUsuario> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(EstadoUsuario.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public EstadoUsuario find(int id) {

        return entityManager.find(EstadoUsuario.class, id);
    }
}
