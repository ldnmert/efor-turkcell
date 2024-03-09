package com.turkcellperf.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.service.AdminService;


@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET})
	@GetMapping("/filtered")
	public ResponseEntity<List<Performance>> filteredPerformance(@RequestParam String memberId,
	        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(required = false) Date  startDate,
	        @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(required = false)  Date endDate) {
		java.sql.Date sqlStartDate = null;
		java.sql.Date sqlEndDate = null;

		if (startDate != null) {
		    sqlStartDate = new java.sql.Date(startDate.getTime());
		}
		if (endDate != null) {
		    sqlEndDate = new java.sql.Date(endDate.getTime());
		}

	    System.out.println(memberId + startDate + endDate + " xdx");
	    List<Performance> performanceFiltered = adminService.listFilteredPerformance(memberId, startDate, endDate);

	    return new ResponseEntity<>(performanceFiltered, HttpStatus.OK);
	}

}
