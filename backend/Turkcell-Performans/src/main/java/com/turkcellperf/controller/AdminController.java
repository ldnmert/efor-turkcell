package com.turkcellperf.controller;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET })
	@GetMapping("/filtered")
	public ResponseEntity<List<Performance>> filteredPerformance(@RequestParam String memberId,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endDate

			, @RequestParam(required = false) String excuse, @RequestParam(required = false) Integer excuseHours,
			@RequestParam(required = false) Integer timeout) {

		System.out.println("hata olmasına ragmen donecek mı");
		java.sql.Date sqlStartDate = null;
		java.sql.Date sqlEndDate = null;

		if (startDate != null) {
			sqlStartDate = new java.sql.Date(startDate.getTime());
		}
		if (endDate != null) {
			sqlEndDate = new java.sql.Date(endDate.getTime());
		}

		System.out.println(memberId + startDate + endDate + " xdx");
		List<Performance> performanceFiltered = adminService.listFilteredPerformance(memberId, startDate, endDate,
				excuse, excuseHours, timeout);

		return new ResponseEntity<>(performanceFiltered, HttpStatus.OK);
	}

}
