package spring.partie6.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.partie6.persistence.dao.ApplicationUserRepository;
import spring.partie6.persistence.entities.ApplicationUser;
import spring.partie6.persistence.entities.UserRole;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        ApplicationUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return loadUserFromDB(username);
    }

    private ApplicationUserDetails loadUserFromDB(String username) throws UsernameNotFoundException {

        ApplicationUser user = userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        for (UserRole userRole: user.getUserRoles()){
            grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole().getNom()));
        }


        return new ApplicationUserDetails(user.getMail(),user.getNom(),user.getUsername(),user.getPassword(),user.isActif(),grantedAuthoritySet);

    }
}

