package com.turkcellperf.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	BCryptPasswordEncoder bc;
	@Autowired 
	AgentRepository ar;
	
	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody Agent agent) {
		
		System.out.println(agent.getPassword());
		agent.setPassword(bc.encode(agent.getPassword()));
		ar.save(agent);
		return new ResponseEntity<>("Kayit olusturuldu.", HttpStatus.CREATED);
		
	}
	
}
