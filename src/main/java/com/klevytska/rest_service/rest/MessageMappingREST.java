package com.klevytska.rest_service.rest;

import com.klevytska.rest_service.entity.MessageMapping;
import com.klevytska.rest_service.registrator.MessageMappingRegistrator;
import com.klevytska.rest_service.repository.MessageMappingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by katerynalevytska on 1/30/17.
 */

@RequestScoped
@Path("/message_mapping")
public class MessageMappingREST {
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
        logger.info("Get full message mapping");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(@PathParam("id") long id){
        logger.info("Get mapping by Id: " + id );
        return repository.getById(id);
    }
}
