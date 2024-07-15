package com.turkcellperf.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.repository.PerformanceRepository;
import com.turkcellperf.repository.PerformanceSpecifications;

@Service
public class AdminServiceImpl implements AdminService {

	PerformanceRepository performanceRepository;

	public AdminServiceImpl(PerformanceRepository performanceRepository) {

		this.performanceRepository = performanceRepository;
	}

	@Override
	public List<Performance> listFilteredPerformance(String memberId, Date startDate, Date endDate, String excuse,
			Integer excuseHours, Integer timeout) {

		Specification<Performance> spec = Specification.where(PerformanceSpecifications.filterByMemberId(memberId))
				.and(PerformanceSpecifications.filterByDateRange(startDate, endDate))
				.and(PerformanceSpecifications.filterByExcuse(excuse))
				.and(PerformanceSpecifications.filterByExcuseHours(excuseHours))
				.and(PerformanceSpecifications.filterByTimeout(timeout));
		return performanceRepository.findAll(spec);

	}
}