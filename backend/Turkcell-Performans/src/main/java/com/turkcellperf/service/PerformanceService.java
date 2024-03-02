package com.turkcellperf.service;

import java.util.List;

import com.turkcellperf.entity.Performance;

public interface PerformanceService {

	List<Performance> listPerformanceOfCurrentAgent();
	Performance getPerformance(Long g);
	void deletePerformance(Performance p);
	void addPerformance(Performance p);
	
	
	
	
}
