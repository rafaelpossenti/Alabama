package com.possenti.task.security;

import com.possenti.task.entity.AuthGroup;
import com.possenti.task.entity.User;
import com.possenti.task.repository.AuthGroupRepository;
import com.possenti.task.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandonUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public LandonUserDetailsService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null) throw new UsernameNotFoundException("cannot find userName " + userName);
        List<AuthGroup> authGroups = authGroupRepository.findByUserName(userName);
        return new LandonUserPrincipal(user, authGroups);
    }
}
