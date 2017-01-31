package com.airhacks.doit.business.reminders.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.lang.model.element.NestingKind;
import org.junit.Before;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author Hijack
 */
public class TodosResourceIT {

//    private Client client;
//    private WebTarget tut;
    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/doit/api/todos");

//    @Before
//    public void initClient() { 
//        this.client = ClientBuilder.newClient();
//        this.tut = this.client.target("http://localhost:8080/doit/api/todos");
//    }
    @Test
    public void crud() {
        
        createToDoWithoutCaption();
        JsonObjectBuilder todoBuilder = Json.createObjectBuilder();
        JsonObject todoToCreate = todoBuilder.add("caption", "implement").add("priority", 10).build();
        
        //create
        Response postResponse = this.provider.target().request().post(Entity.json(todoToCreate));
        assertThat(postResponse.getStatus(), is(201));
        String location = postResponse.getHeaderString("Location");
        System.out.println("location: " + location);
        
        //find
        JsonObject dedicatedTodo = this.provider.client().target(location).request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertTrue(dedicatedTodo.getString("caption").contains("implement"));
        
        //update
        JsonObjectBuilder updateBuilder = Json.createObjectBuilder();
        JsonObject updatet = updateBuilder.add("caption", "implemented").build();
        
        Response updateResponse = this.provider.client().target(location).request(MediaType.APPLICATION_JSON).put(Entity.json(updatet));
        assertThat(updateResponse.getStatus(), is(200));
        
        //update again, TEST for optmistic locking -> requirement: at least two updates simultaniously
        updateBuilder = Json.createObjectBuilder();
        updatet = updateBuilder.add("caption", "implemented").add("priority", 42).build();
        
        updateResponse = this.provider.client().target(location).request(MediaType.APPLICATION_JSON).put(Entity.json(updatet));
        assertThat(updateResponse.getStatus(), is(409)); //409 to see the conflict, intended exception
        String conflictInformation = updateResponse.getHeaderString("cause");
        assertNotNull(conflictInformation);
        System.out.println("conflictInformation = " + conflictInformation);
        //throws
        //Caused by: javax.ejb.EJBException: javax.persistence.OptimisticLockException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect) : [com.airhacks.doit.business.reminders.entity.ToDo#2]
        //by: org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect) : [com.airhacks.doit.business.reminders.entity.ToDo#2]
        
        //find it again
        JsonObject updatetToDo = this.provider.client().target(location).request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertTrue(updatetToDo.getString("caption").contains("implement"));
        
        //update status
        //update
        JsonObjectBuilder statusBuilder = Json.createObjectBuilder();
        JsonObject status = statusBuilder.add("done", true).build();
        
        this.provider.client().target(location).path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(status));
        
        //verfiy status
        updatetToDo = this.provider.client().target(location).request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertThat(updatetToDo.getBoolean("done"), is(true));
        
        //update not existing status
        //update
        JsonObjectBuilder notExistingBuilder = Json.createObjectBuilder();
        status = notExistingBuilder.add("done", true).build();
        
        Response response = this.provider.target().path("-42").path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(status));
        assertThat(response.getStatus(), is(400));
        assertFalse(response.getHeaderString("reason").isEmpty());
        
        //update malformed status
        JsonObjectBuilder nonExistingBuilder = Json.createObjectBuilder();
        status = nonExistingBuilder.add("somethingWrong", true).build();
        
        response = this.provider.client().target(location).path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(status));
        assertThat(response.getStatus(), is(400));
        assertFalse(response.getHeaderString("reason").isEmpty());
        
        //findAll
//        Response response = this.tut.request(MediaType.TEXT_PLAIN).get();
        response = this.provider.target().request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonArray allTodos = response.readEntity(JsonArray.class);
        System.out.println("payload: " + allTodos);
        assertFalse(allTodos.isEmpty());
        
        JsonObject todo = allTodos.getJsonObject(0);
        System.out.println("-------------------" + todo.getString("caption"));
        assertTrue(todo.getString("caption").startsWith("impl"));
        
        //deleting not-existing
        //DELETE with Id
        Response deleteResponse = this.provider.target().path("42").request(MediaType.APPLICATION_JSON).delete();
        assertThat(deleteResponse.getStatus(), is(204));
    }
    
    @Test
    public void createToDoWithoutCaption() {
        JsonObjectBuilder todoBuilder = Json.createObjectBuilder();
        JsonObject todoToCreate = todoBuilder.add("priority", 42).build();
        //create
        Response postResponse = this.provider.target().request().post(Entity.json(todoToCreate));
        assertThat(postResponse.getStatus(), is(400));
        postResponse.getHeaders().entrySet().forEach(System.out::println);
    }
    
    @Test
    public void createValidToDo() {
        JsonObjectBuilder todoBuilder = Json.createObjectBuilder();
        JsonObject todoToCreate = todoBuilder.add("caption", "12").add("priority", 9).build();
        //create
        Response postResponse = this.provider.target().request().post(Entity.json(todoToCreate));
        assertThat(postResponse.getStatus(), is(201));
        postResponse.getHeaders().entrySet().forEach(System.out::println);
    }
    @Test
    public void createToDoWithHighPriorityWithoutDescription() {
        JsonObjectBuilder todoBuilder = Json.createObjectBuilder();
        JsonObject todoToCreate = todoBuilder.add("caption", "10").add("priority", 12).build();
        //create
        Response postResponse = this.provider.target().request().post(Entity.json(todoToCreate));
        assertThat(postResponse.getStatus(), is(400));
        postResponse.getHeaders().entrySet().forEach(System.out::println);
    }

}
