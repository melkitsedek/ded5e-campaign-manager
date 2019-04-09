package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/testModule")
public class TestModule {
	
	@GET
	@Path("/echo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestEcho(
			@QueryParam("string") String text
			) {
		try {
			return "echoed: " + text;
		} catch (NullPointerException e) {
			return "null text";
		}
	}
	
	@GET
	@Path("/helloworld")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHelloWorld() {
		return "Hello, World!";
	}
}
