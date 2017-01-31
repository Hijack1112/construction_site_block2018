package com.airhacks.di.presentation;


import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messages")
public class MessagesRessources {
	
	/**
	 * Call by localhost:8080/DiWithServer/resources/messages
	 * 
	 * /DiWithServer/ == Context URI of the war
	 * /resources/ == name of JAXRS Application
	 * 
	 * 
	 * @return
	 */
	
	/**
	 * Serialization by JAXB
	 * try out with http://localhost:8080/AdamBien_JavaEE_DiWithServer/resources/messages/32
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{id}")
	public Message message(@PathParam("id") long id ) {
		return new Message("hello from message " + id);
	}
	
	/**
	 * try out: http://localhost:8080/AdamBien_JavaEE_DiWithServer/resources/messages
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> message() {
		List<Message> messages = new ArrayList<>();
		messages.add(new Message("duke"));
		messages.add(new Message("juggy"));
		return messages;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject jsonMessage() {
		return Json.createObjectBuilder().add("content", "duke42").build();
	}
	
	/**
	 * POST means we don't the resource id. The server would compute the resource id. Internal it means we could get duplicates
	 * not ident potent method
	 * PUT means we have the message Id, the first time the message will be created and second time and third time updatet, so no sideffects in case you send the same id multiple times
	 * 
	 * @Valid means that BeanValidation inside of message object will be executed
	 * 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(@Valid Message message) {
		System.out.println("Message: " + message);
	}
	
}
