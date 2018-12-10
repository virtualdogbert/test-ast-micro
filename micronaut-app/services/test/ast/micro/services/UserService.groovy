package test.ast.micro.services

import test.ast.micro.UserDomain

class UserService {

    UserDomain getUser(Long id){
        UserDomain.get(id)
    }

    UserDomain createUser(String username, String email, String password){
        UserDomain user = new UserDomain(username: username, email: email, password: password)
        user.save() ?: user
    }
}
