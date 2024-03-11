package com.turkcellperf.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellperf.entity.Agent;
import com.turkcellperf.repository.AgentRepository;

@RestController
public class ProfileService {

	@Autowired
	AgentRepository ar;

	private String save;

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/profile-info/{agentId}")
	ResponseEntity<List<String>> getInfos(@PathVariable String agentId) {

		save = agentId;
		Agent agent = ar.findByAgentId(agentId);

		List<String> infos = Arrays.asList(agent.getAgentId(), agent.getFirstName(), agent.getSurname(),
				agent.getPhoto());
		System.out.println(infos);
		return new ResponseEntity<>(infos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/profile-info/")
	ResponseEntity<List<String>> getInfos2() {

		Agent agent = ar.findByAgentId(save);

		List<String> infos = Arrays.asList(agent.getAgentId(), agent.getFirstName(), agent.getSurname(),
				agent.getPhoto());
		System.out.println(infos);
		return new ResponseEntity<>(infos, HttpStatus.OK);
	}

}
