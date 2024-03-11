package com.turkcellperf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.service.PerformanceService;

@RestController
@RequestMapping("/rest")
//@CrossOrigin("*")
public class TableController {

	private final PerformanceService performanceService;

	private String save;

	@Autowired
	public TableController(PerformanceService performanceService) {
		this.performanceService = performanceService;
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/{agentId}")
	public ResponseEntity<List<Performance>> getAllPerformance(@PathVariable String agentId) {
		
		save = agentId;
		List<Performance> p = performanceService.listPerformanceOfCurrentAgent(agentId);
		return new ResponseEntity<>(p, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/")
	public ResponseEntity<List<Performance>> getAllPerformance2() {
	
		List<Performance> p = performanceService.listPerformanceOfCurrentAgent(save);
		return new ResponseEntity<>(p, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_USER')")
//	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/aaa")
	public ResponseEntity<String> deneme() {

		return new ResponseEntity<>("yes", HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePerformance(@PathVariable Long id) {
		System.out.println(id);
		Performance p = performanceService.getPerformance(id);
		performanceService.deletePerformance(p);

		return ResponseEntity.ok().body("{\"message\": \"Deleted\"}");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePerformance(@PathVariable Long id, @RequestBody Performance performance) {

		performance.setId(id);
		performanceService.addPerformance(performance);

		return ResponseEntity.ok().body("{\"message\": \"Updated\"}");

	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping
	public ResponseEntity<Performance> addPerformance(@RequestBody Performance p) {
		System.out.println(p.getExcuse());
		Performance savedPerformance = performanceService.addPerformance(p);

		return new ResponseEntity<>(savedPerformance, HttpStatus.CREATED);
	}

}
