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
}

