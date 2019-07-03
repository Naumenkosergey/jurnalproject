package com.itacademy.web.services;

import com.google.common.collect.ImmutableList;
import com.itacademy.web.domain.Role;
import com.itacademy.web.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return (UserDetails) userRepository.findByLogin(username).orElse(null);
        return User.builder()
                .username(username)
                .password("$2a$10$aT6.K009vybdhAnJ6gHDv.W0loYvTWbJ34Sm0hvq6BT/vOEXRhgI2")
                .authorities(ImmutableList.of(Role.USER))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();

    }
}
