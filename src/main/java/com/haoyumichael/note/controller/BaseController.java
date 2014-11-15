package com.haoyumichael.note.controller;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.haoyumichael.note.dao.NoteDao;
import com.haoyumichael.note.domain.Note;

@Controller
@Path("notes")
public class BaseController {

	@Autowired
	private NoteDao noteDao;
	
	@GET
	@Path("")
	@Produces("text/html")
	public void getEvent(@Context HttpServletResponse response,
	        @Context HttpServletRequest request) throws ServletException,
	        IOException {

	    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}
 
	@GET
	@Path("load")
	@Produces({MediaType.APPLICATION_JSON})
	public Object loadNotes() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(noteDao.selectNotes());
	}
	
	@GET
	@Path("load/{id}")
	public String getSingleNote(@PathParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(noteDao.selectSingleNote(id));
	}
	
	@POST
	@Path("/save")
	public String saveNote(Note note) throws JsonGenerationException, JsonMappingException, IOException { 
		System.out.println("saving note.......");
		noteDao.insertNote(note);
		Map<String, String> result = new HashMap<String,String>();
		result.put("success", "true");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
	
	@PUT
	@Path("/update/{id}")
	public String updateNote(Note note) {
		System.out.println("updating note.......");
		noteDao.updateNote(note);
		return "update ok"; 
	}

	@DELETE
	@Path("/load/{id}")
	public String deleteNote(@PathParam("id") int id) {
		System.out.println("deleting note.......");
		noteDao.deleteNote(id);
		return "delete ok"; 
	}
	
	// experimental only, not in use
	@Path("error")
	@GET
	@Produces({MediaType.APPLICATION_XML}) 
	public String testError() throws ArithmeticException
	{
		try {
            if((100 / 0) > 0) {
            }
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero!");
        }
        return "errorTest";
	}
 
}