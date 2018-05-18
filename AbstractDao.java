/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alan.oliveira.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author windows
 * @param <E>
 * @param <K>
 */
public abstract class AbstractDao<E, K> {

    protected final EntityManager em;

    private Class<E> clazz = (Class<E>) 
        ((ParameterizedType) 
        this.getClass().getGenericSuperclass()).
        getActualTypeArguments()[0];

    public AbstractDao(EntityManager em) {
        this.em = em;
    }

    public List<E> findAll(){
        return em.createQuery(
            "from " + clazz.getSimpleName()
            ).getResultList();
    }
       
}
