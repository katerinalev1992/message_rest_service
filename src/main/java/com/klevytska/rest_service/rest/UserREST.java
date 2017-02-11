package com.klevytska.rest_service.rest;

import com.klevytska.rest_service.entity.User;
import com.klevytska.rest_service.registrator.UserRegistrator;
import com.klevytska.rest_service.repository.UserRepository;

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
 * Created by katerynalevytska on 2/11/17.
 */

@Path("/user")
@RequestScoped
public class UserREST {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    UserRegistrator userRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUSers(){
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id){
        return  userRepository.getById(id);
    }
}
