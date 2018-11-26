package test.ast.micro

import io.micronaut.security.annotation.Secured
import test.ast.micro.services.VelocityService

import javax.annotation.Nullable
import java.security.Principal

@Secured("isAnonymous()") // <1>
//@Controller("/") // <2>
class HomeController {

    protected final VelocityService velocityService

    HomeController(VelocityService velocityService) { // <3>
        this.velocityService = velocityService
    }

    //@Produces(MediaType.TEXT_HTML) // <4>
    //@Get("/") // <5>
    String index(@Nullable Principal principal) { // <6>
        velocityService.render("home.vm", homeModel(principal))
    }

    private Map homeModel(@Nullable Principal principal) {
        Map<String, Object> data = (Map<String, Object>)["loggedIn": principal!=null]
        if (principal) {
            data.username = principal.name
        }
        data
    }
}