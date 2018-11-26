package test.ast.micro


import io.micronaut.security.annotation.Secured
import test.ast.micro.services.VelocityService
//@CompileStatic
@Secured("isAnonymous()") // <1>
//@Controller("/login") // <2>
class LoginAuthController {

    protected final VelocityService velocityService

//    LoginAuthController(VelocityService velocityService) { // <3>
//        this.velocityService = velocityService
//    }

    //@Produces(MediaType.TEXT_HTML) // <4>
    //@Get("/auth") // <5>
    String auth() {
        velocityService.render("auth.vm", [:]) // <6>
    }

    //@Produces(MediaType.TEXT_HTML) // <4>
    //@Get("/authFailed") // <7>
    String authFailed() {
        velocityService.render("auth.vm", authFailedModel()) // <6>
    }

    private Map<String, Object> authFailedModel() {
        [errors: true] as Map<String, Object>
    }
}