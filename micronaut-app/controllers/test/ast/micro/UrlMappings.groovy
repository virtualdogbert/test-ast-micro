package test.ast.micro

home {
    url = '/'
    index {
        url = '/'
        method = 'GET'
        produces = 'text/html'
    }
}

loginAuth {
    url = '/login'

    auth {
        method = 'GET'
        produces = 'text/html'
    }

    authFailed {
        method = 'GET'
        produces = 'text/html'
    }

    username {
        method = 'GET'
        produces = 'text/html'
    }

    createUser {
        method = 'GET'
        produces = 'text/html'
    }
}

