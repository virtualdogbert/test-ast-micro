package test.ast.micro


import io.micronaut.security.annotation.Secured
import test.ast.micro.services.VelocityService
@Secured("isAnonymous()") // <1>>
class LoginAuthController {

    protected final VelocityService velocityService

//    LoginAuthController(VelocityService velocityService) { // <3>
//        this.velocityService = velocityService
//    }

    String auth() {
        velocityService.render("auth.vm", [:]) // <6>
    }

    String authFailed() {
        velocityService.render("auth.vm", authFailedModel()) // <6>
    }

    private Map<String, Object> authFailedModel() {
        [errors: true] as Map<String, Object>
    }
}