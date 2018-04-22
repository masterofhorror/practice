/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltc.dao.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author dsalamanca
 */
public class GenericDAO<T> {

    private static final Logger LOG = Logger.getLogger(GenericDAO.class.getSimpleName());

    private Class<T> entityClass;

    @PersistenceContext(unitName = "LtcPU")
    protected EntityManager entityManager;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Funcion que permite persistir un objeto en base de datos
     *
     * @param t Clase Generica T
     * @return True si la transacción se realiza exitosamente, False en caso
     * contrario
     */
    public boolean create(T t) {
        try {
            this.entityManager.persist(t);
            return true;
        } catch (PersistenceException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> create >> error [0]", e.getCause());
        }
        return false;
    }

    /**
     * Funcion que permite consultar un objeto por su id
     *
     * @param id Identificador del registro a buscar
     * @return Datos del objeto
     */
    public T read(Object id) {
        return (T) this.entityManager.find(entityClass, id);
    }

    /**
     * Funcion que permite actualizar un objeto en base de datos
     *
     * @param t Clase Generica T
     * @return True si la transacción se realiza exitosamente, False en caso
     * contrario
     */
    public boolean update(T t) {

        try {
            this.entityManager.merge(t);
            return true;
        } catch (PersistenceException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> update >> error [0]", e.getCause());
        }
        return false;
    }

    /**
     * Funcion que permite eliminar un objeto en base de datos
     *
     * @param t Clase Generica T
     * @return True si la transacción se realiza exitosamente, False en caso
     * contrario
     */
    public boolean delete(T t) {
        try {
            t = this.entityManager.merge(t);
            this.entityManager.remove(t);
            return true;
        } catch (PersistenceException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> delete >> error [0]", e.getCause());
        }
        return false;
    }

    /**
     * Permite consultar todos los registros de una entidad
     *
     * @param query Consulta a ejecutar
     * @return List<Class<T>
     */
    public List<T> listarAll(String query) {
        try {
            return (List<T>) entityManager.createNamedQuery(query).getResultList();
        } catch (NoResultException | ClassCastException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> listarAll >> error [0]", e.getCause());
        }
        return new ArrayList<>();
    }

    /**
     * Metodo que consulta todos los registros de una entidad sin query de
     * entrada
     *
     * @return List<T>
     */
    public List<T> listarAll() {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq).getResultList();
    }

    /**
     * Permite realizar una consulta generica con filtros de búsqueda
     *
     * @param jpql Query a ejectutar
     * @param params Lista de parametros
     * @return List<Class<T>>
     */
    public List<T> filtrar(String jpql, Map<String, Object> params) {
        try {
            Query query = entityManager.createNamedQuery(jpql);
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
            return (List<T>) query.getResultList();
        } catch (NoResultException | ClassCastException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> filtrar >> error [0]", e.getCause());
        }
        return new ArrayList<>();
    }

    public List<T> filtrarMaxResults(String jpql, Map<String, Object> params, Integer maximo) {
        try {
            Query query = entityManager.createNamedQuery(jpql);
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
            query.setFirstResult(0);
            query.setMaxResults(maximo);
            return (List<T>) query.getResultList();
        } catch (NoResultException | ClassCastException e) {
            LOG.log(Level.SEVERE, " GenericDaoJpaImpl >> filtrar >> error [0]", e.getCause());
        }
        return new ArrayList<T>();
    }

    /**
     * Funcion que permite consultar la cantidad de registros en base de datos
     *
     * @param params Lista de parametros
     * @return Cantidad de registros
     */
    public long count(Map<String, Object> params) {
        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");
        queryString.append(entityClass.getSimpleName()).append(" o ");
        //queryString.append(this.getQueryClauses(params, null));
        final Query query = this.entityManager.createQuery(queryString.toString());
        return (Long) query.getSingleResult();
    }

    /**
     * Permite realizar una consulta generica con filtros de búsqueda
     *
     * @param jpql Query a ejectutar
     * @param params Lista de parametros
     * @return T
     */
    public T filtrarUnicoRegistro(String jpql, Map<String, Object> params) {
        try {
            Query query = entityManager.createNamedQuery(jpql);
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
            return (T) query.getSingleResult();
        } catch (NoResultException | ClassCastException | NonUniqueResultException | IllegalArgumentException e) {
            LOG.log(Level.SEVERE, " filtrarUnicoRegistro >> filtrar >> error [0]", e.getCause());
        }
        return null;
    }

    /**
     * Funcion que permite consultar la cantidad de registros de una consulta
     *
     * @param jqpl Consulta
     * @param params Parametros de la consulta
     * @return long
     */
    public Integer countQuery(String jqpl, Map<String, Object> params) {
        Query query = this.entityManager.createNamedQuery(jqpl);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return Integer.parseInt(String.valueOf(query.getSingleResult().toString()));
    }

    /**
     * Funcion que permite consultar información basado en consultas nativas
     *
     * @param nativeQuery Consulta nativa
     * @param params Parametros a pasar a la consulta
     * @return Listado de objetos
     */
    public List<Object[]> consultaNativa(String nativeQuery, Map<Integer, Object> params) {

        Query query = this.entityManager.createNativeQuery(nativeQuery);
        for (Integer posicion : params.keySet()) {
            query.setParameter(posicion, params.get(posicion));
        }
        return query.getResultList();
    }

}
