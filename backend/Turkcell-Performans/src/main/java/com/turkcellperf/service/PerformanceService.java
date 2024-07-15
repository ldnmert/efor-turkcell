package com.turkcellperf.service;

import java.util.List;

import com.turkcellperf.entity.Performance;

public interface PerformanceService {

	List<Performance> listPerformanceOfCurrentAgent(String agentId);

	Performance getPerformance(Long g);

	void deletePerformance(Performance p);

	Performance addPerformance(Performance p);
<<<<<<< HEAD

=======
	
>>>>>>> 1f50cc790b6a37df720206fc3d9c537e982776c2
}
