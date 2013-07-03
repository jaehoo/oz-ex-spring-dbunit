package com.bc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author Lic. Jose Alberto Sanchez Gonzalez (jaehoo@gmail.com)
 * web: www.orbitalzero.com , www.orbitalzero.org
 * Date: 25/07/11
 * Time: 01:12 PM
 */
public abstract class AbstractDao<T, K extends Serializable>{

    @PersistenceContext(unitName = "OZPU")
    protected EntityManager em;

    public void save(T t){
        em.persist(t);
    }

    public void delete(T t){
        em.remove(t);
    }

    public T update(T t){
        return em.merge(t);
    }

    public T find(Class clazz ,K id){
        return (T) em.find(clazz,id);
    }

    public void flush(){
        em.flush();
    }

    public void clear(){
        em.clear();
    }
}
