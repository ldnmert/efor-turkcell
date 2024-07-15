package com.turkcellperf.service;

import java.util.Date;
import java.util.List;

import com.turkcellperf.entity.Performance;

public interface AdminService {

	List<Performance> listFilteredPerformance(String memberId, Date startDate, Date endDate,
			String excuse, Integer excuseHours, Integer timeout);
	
}