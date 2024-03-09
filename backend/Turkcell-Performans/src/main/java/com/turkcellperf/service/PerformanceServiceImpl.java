package com.turkcellperf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.repository.PerformanceRepository;

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



}
