package com.turkcellperf.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.service.PerformanceService;

@RestController
@RequestMapping("/rest")
public class TableController {

	private final PerformanceService performanceService;

	@Autowired
	public TableController(PerformanceService performanceService) {
		this.performanceService = performanceService;
	}

	@GetMapping
	ResponseEntity<List<Performance>> getAllPerformance() {

		List<Performance> p = performanceService.listPerformanceOfCurrentAgent();
		return new ResponseEntity<>(p, HttpStatus.OK);

	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.DELETE })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePerformance(@PathVariable Long id) {
		System.out.println(id);
		Performance p = performanceService.getPerformance(id);
		performanceService.deletePerformance(p);

		return ResponseEntity.ok().body("{\"message\": \"Deleted\"}");
	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.PUT })
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePerformance(@PathVariable Long id, @RequestBody Performance performance) {

		performance.setId(id);
		performanceService.addPerformance(performance);

		return ResponseEntity.ok().body("{\"message\": \"Updated\"}");

	}

	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST })
	@PostMapping
	public ResponseEntity<Performance> addPerformance(@RequestBody Performance p) {

		Performance savedPerformance = performanceService.addPerformance(p);

		return new ResponseEntity<>(savedPerformance, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/filtered")
	public ResponseEntity<List<Performance>> filteredPerformance(@RequestParam String memberId, @RequestParam Date startDate, @RequestParam Date endDate){
		System.out.println(memberId + startDate + endDate +" xdx");
		List<Performance> performanceFiltered = performanceService.listFilteredPerformance(memberId, startDate, endDate);
		
		return new ResponseEntity<>(performanceFiltered, HttpStatus.OK);
	}

}
