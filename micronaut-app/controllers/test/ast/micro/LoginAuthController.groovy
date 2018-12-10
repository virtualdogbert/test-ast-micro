package test.ast.micro

import io.micronaut.security.annotation.Secured
import test.ast.micro.services.UserService
import test.ast.micro.services.VelocityService

@Secured("isAnonymous()") // <1>>
class LoginAuthController {

    protected final VelocityService velocityService
    protected final UserService     userService

//    LoginAuthController(VelocityService velocityService) { // <3>
//        this.velocityService = velocityService
//    }

    String auth() {
        velocityService.render("auth.vm", [:]) // <6>
    }

    String authFailed() {
        velocityService.render("auth.vm", authFailedModel()) // <6>
    }

    @Secured("isAnonymous()")
    String username(){
        userService.getUser(1).username
    }

    @Secured("isAnonymous()")
    String createUser(){
        userService.createUser('testUser', 'something@somethingelse.com', 'password')
    }

    private Map<String, Object> authFailedModel() {
        [errors: true] as Map<String, Object>
    }
}