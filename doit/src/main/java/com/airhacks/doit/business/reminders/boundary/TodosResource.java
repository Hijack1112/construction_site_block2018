package com.airhacks.doit.business.reminders.boundary;

import com.airhacks.doit.business.reminders.entity.ToDo;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("todos")
public class TodosResource {

    @Inject
    TodoManager manager;

    @Path("{id}")
    public ToDoResource find(@PathParam("id") long id) {
        return new ToDoResource(id, manager);
    }
    
    @GET
    public List<ToDo> all() {
        return manager.all();
    }

    //Use @POST for generating technical keys on the server, use @PUT for transmitting business keys in form of an update
    @POST
    public Response save(@Valid ToDo toDo, @Context UriInfo info) {
        ToDo saved = this.manager.save(toDo);

        long id = saved.getId();
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        return Response.created(uri).build();
    }
}
