package br.org.melk.control;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.org.melk.model.Character;
import br.org.melk.model.DatabaseManager;
import br.org.melk.model.User;

@Path("/request")
public class RequestController {
	
	@POST
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public User requestLogin(
			@FormParam("email") String email,
			@FormParam("password") String password
			) {
		try {
			User u = DatabaseManager.getUser(email, password);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Response saveCharacter(Character c, User u) {
		try {
			u.addCharacter(c);
			return Response.status(200).entity(true).build();
		} catch (Exception e) {
			return Response.status(200).entity(false).build();
		}
		
	}
}
