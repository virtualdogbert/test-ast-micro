package test.ast.micro.services


import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
//@CompileStatic
//@Singleton // <1>
class AuthenticationProviderUserPassword implements AuthenticationProvider  { // <2>
    @Override
    Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if ( authenticationRequest.identity == "sherlock" && authenticationRequest.secret == "password" ) {
            UserDetails userDetails = new UserDetails((String) authenticationRequest.identity, new ArrayList<>())
            return Flowable.just(userDetails) as Flowable<AuthenticationResponse>
        }
        Flowable.just(new AuthenticationFailed()) as Flowable<AuthenticationResponse>
    }
}