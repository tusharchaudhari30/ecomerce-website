package com.ecomerce.Service;

import com.ecomerce.Model.MainUser;
import com.ecomerce.Model.User;
import com.ecomerce.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepo.findUserByEmail(email);
        if(u==null)
            throw new UsernameNotFoundException("user not found");

        return new MainUser(u);
    }
}
