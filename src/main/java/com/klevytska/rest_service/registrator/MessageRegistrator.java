package com.klevytska.rest_service.registrator;

import com.klevytska.rest_service.entity.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 1/29/17.
 */
@Stateless
public class MessageRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(Message item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void  update (Message item){
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete (Message item){
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}