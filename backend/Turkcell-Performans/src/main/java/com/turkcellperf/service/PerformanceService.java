package com.turkcellperf.service;

import java.util.List;

import com.turkcellperf.entity.Performance;

public interface PerformanceService {

	List<Performance> listPerformanceOfCurrentAgent(String agentId);

	Performance getPerformance(Long g);

	void deletePerformance(Performance p);

	Performance addPerformance(Performance p);
	
	

	

}
