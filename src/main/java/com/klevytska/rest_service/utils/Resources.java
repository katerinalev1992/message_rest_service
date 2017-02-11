package com.klevytska.rest_service.utils;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 2/11/17.
 */
public class Resources {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

}
