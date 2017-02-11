package com.klevytska.rest_service.repository;

import com.klevytska.rest_service.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 1/29/17.
 */

@ApplicationScoped
public class UserRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public User getById(long id){
        logger.info("Get User by id: " + id);
        return entityManager.find(User.class, id);
    }

    public User getByUserName(String nick_name){
        logger.info("Get users by nick_name: " + nick_name);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> element = criteriaQuery.from(User.class);

        criteriaQuery.select(element).where(criteriaBuilder.equal(element.get("nick_name"), nick_name));
        return  entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<User> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

