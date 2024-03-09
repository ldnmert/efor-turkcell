package com.turkcellperf.service;

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
	public List<Performance> listFilteredPerformance(String memberID, Date startDate, Date endDate) {

		Specification<Performance> spec = Specification.where(PerformanceSpecifications.filterByMemberId(memberID))
				.and(PerformanceSpecifications.filterByDateRange(startDate, endDate));
//		System.out.println(pr.findAll(spec).get(0).getTimeout());
		return pr.findAll(spec);

	}
}
