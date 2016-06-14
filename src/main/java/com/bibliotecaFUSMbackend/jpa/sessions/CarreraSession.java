/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bibliotecaFUSMbackend.jpa.sessions;

import com.bibliotecaFUSMbackend.jpa.entities.Carrera;
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
public class CarreraSession {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Carrera carrera) {
        entityManager.persist(carrera);
    }

    public void update(Carrera carrera) {
        entityManager.merge(carrera);

    }

    public void remove(Carrera carrera) {
        entityManager.remove(carrera);

    }

    public List<Carrera> findAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Carrera.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public Carrera find(int id) {

        return entityManager.find(Carrera.class, id);
    }
    
    
    public List<Carrera> findByName(String name){
        try{
        return (List<Carrera>) entityManager.createNamedQuery("Carrera.findByNombre")
                .setParameter("nombre", name+"%")
                .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
