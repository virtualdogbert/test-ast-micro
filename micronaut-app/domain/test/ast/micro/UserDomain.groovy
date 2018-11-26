package test.ast.micro


import io.micronaut.security.authentication.providers.UserState
import org.grails.datastore.gorm.GormEntity
//This only needs to be in this package because of a bug, that was fixed:
//https://github.com/micronaut-projects/micronaut-core/issues/511
class UserDomain implements GormEntity<UserDomain>, UserState { // <2>
    String email
    String username
    String password
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    static constraints = {
        email nullable: false, blank: false
        username nullable: false, blank: false, unique: true
        password nullable: false, blank: false, password: true
    }

    static mapping = {
        password column: '`password`'
    }
}