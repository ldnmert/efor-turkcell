package com.turkcellperf.service;

import java.sql.Date;
import java.util.List;

import com.turkcellperf.entity.Performance;

public interface PerformanceService {

	List<Performance> listPerformanceOfCurrentAgent();

	Performance getPerformance(Long g);

	void deletePerformance(Performance p);

	Performance addPerformance(Performance p);

	List<Performance> listFilteredPerformance(String memberID, Date startDate, Date endDate);

}
