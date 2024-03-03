package com.turkcellperf.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.repository.PerformanceRepository;
import com.turkcellperf.repository.PerformanceSpecifications;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	@Autowired
	PerformanceRepository pr;

	@Override
	public List<Performance> listPerformanceOfCurrentAgent() {
		return pr.findAll();
	}

	@Override
	public Performance getPerformance(Long p) {
		// TODO will be implement.
		return pr.findById(p).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void deletePerformance(Performance p) {
		pr.delete(p);

	}

	@Override
	public Performance addPerformance(Performance p) {
		Performance savedPerformance = pr.save(p);
		return savedPerformance;
	}

	@Override
	public List<Performance> listFilteredPerformance(String memberID, Date startDate, Date endDate) {

		Specification<Performance> spec = Specification.where(PerformanceSpecifications.filterByMemberId(memberID))
				.and(PerformanceSpecifications.filterByDateRange(startDate, endDate));
//		System.out.println(pr.findAll(spec).get(0).getTimeout());
		return pr.findAll(spec);

	}

}
