package security;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import repository.user.HibernateUserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("repository.user")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final HibernateUserRepository userService;

    @Autowired
    public CustomAuthenticationProvider(HibernateUserRepository userService) {
        this.userService = userService;
    }

    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        User user = userService.login(username, password);
        if (user == null) {
            throw new BadCredentialsException("Invalid username/password");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}