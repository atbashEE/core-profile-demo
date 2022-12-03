package be.atbash.jakarta.core.demo.resources;

import be.atbash.jakarta.core.demo.service.HelloService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path(("/hello"))
@ApplicationScoped
public class HelloResource {

    @Inject
    private HelloService helloService;


    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        return String.format(helloService.defineHelloMessage(), name);
    }
}
