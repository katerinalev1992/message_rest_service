package com.klevytska.rest_service.registrator;

import com.klevytska.rest_service.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 1/29/17.
 */
@Stateless
public class UserRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(User item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void  update (User item){
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete (User item){
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}