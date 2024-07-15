package com.turkcellperf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellperf.entity.Agent;
import com.turkcellperf.repository.AgentRepository;

@RestController
@RequestMapping
public class AuthController {

	
	private final BCryptPasswordEncoder passwordEncoder;

	private final AgentRepository agentRepository;
	
	
	public AuthController(BCryptPasswordEncoder passwordEncoder, AgentRepository ar) {
	
		this.passwordEncoder = passwordEncoder;
		this.agentRepository = ar;
	}


	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody Agent agent) {
		
		System.out.println(agent.getPassword());
		agent.setPassword(passwordEncoder.encode(agent.getPassword()));
		agentRepository.save(agent);
		return new ResponseEntity<>("Kayit olusturuldu.", HttpStatus.CREATED);
		
	}
	
}
