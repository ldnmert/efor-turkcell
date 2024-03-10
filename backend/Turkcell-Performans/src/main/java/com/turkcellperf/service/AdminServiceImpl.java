package com.turkcellperf.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.repository.PerformanceRepository;
import com.turkcellperf.repository.PerformanceSpecifications;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	PerformanceRepository pr;
	
	
	@Override
	public List<Performance> listFilteredPerformance(String memberId, Date startDate, Date endDate, 
			 String excuse, Integer excuseHours, Integer timeout) {

		   Specification<Performance> spec = Specification.where(PerformanceSpecifications.filterByMemberId(memberId))
		            .and(PerformanceSpecifications.filterByDateRange(startDate, endDate))
//		            .and(PerformanceSpecifications.filterByTimestampRange(begin, end))
		            .and(PerformanceSpecifications.filterByExcuse(excuse))
		            .and(PerformanceSpecifications.filterByExcuseHours(excuseHours))
		            .and(PerformanceSpecifications.filterByTimeout(timeout));
		return pr.findAll(spec);

	}
}
