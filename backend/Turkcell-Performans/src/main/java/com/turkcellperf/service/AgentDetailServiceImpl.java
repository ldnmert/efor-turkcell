package com.turkcellperf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Agent;
import com.turkcellperf.repository.AgentRepository;

@Service
public class AgentDetailServiceImpl implements UserDetailsService {

	
	
    @Autowired
    private AgentRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       System.out.println();
    	Agent userEntity = userRepository.findByAgentId(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
   System.out.println(userEntity.getRoleName());
   
        System.out.println("asds");
        return org.springframework.security.core.userdetails.User.builder()
        		.username(userEntity.getAgentId())
        		.password(userEntity.getPassword())
        		.roles(userEntity
        				.getRoleName()
        				.toString())
        				.build();
    }

}
