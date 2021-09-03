package spring.partie6.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.partie6.persistence.dao.security.UserRepository;
import spring.partie6.persistence.entities.User;
import spring.partie6.persistence.entities.UserRole;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return loadUserFromDB(username);
    }

    private ApplicationUserDetails loadUserFromDB(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        for (UserRole userRole: user.getUserRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getNom()));
        }


        return new ApplicationUserDetails(user.getMail(),user.getPrenom() +" "+ user.getNom(),user.getUsername(),user.getPassword(),user.isActif(),grantedAuthoritySet);

    }
}

