package com.turkcellperf.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Agent;
import com.turkcellperf.repository.AgentRepository;

@Service
public class AgentDetailServiceImpl implements UserDetailsService {

	private final AgentRepository userRepository;

	public AgentDetailServiceImpl(AgentRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Agent userEntity = userRepository.findByAgentId(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		return org.springframework.security.core.userdetails.User.builder().username(userEntity.getAgentId())
				.password(userEntity.getPassword()).roles(userEntity.getRoleName().toString()).build();
	}

}
