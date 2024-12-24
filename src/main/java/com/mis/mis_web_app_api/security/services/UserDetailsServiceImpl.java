package com.mis.mis_web_app_api.security.services;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.models.User;
import com.mis.mis_web_app_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndStatus(username, Constants.STATUS_ACTIVE)
                .or(() -> userRepository.findByPhoneNumberAndStatus(username, Constants.STATUS_ACTIVE))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username or phone: " + username));

        return UserDetailsImpl.build(user);
    }
}
