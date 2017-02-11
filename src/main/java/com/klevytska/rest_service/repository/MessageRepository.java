package com.klevytska.rest_service.repository;

import com.klevytska.rest_service.entity.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 1/29/17.
 */

@ApplicationScoped
public class MessageRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Message getById(long id){
        logger.info("Get message by id: " + id);
        return entityManager.find(Message.class, id);
    }

    public List<Message> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
