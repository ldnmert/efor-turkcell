package com.turkcellperf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcellperf.entity.Performance;
import com.turkcellperf.repository.PerformanceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PerformanceServiceImpl implements PerformanceService {

	private final PerformanceRepository performanceRepository;

	public PerformanceServiceImpl(PerformanceRepository performanceRepository) {

		this.performanceRepository = performanceRepository;
	}

	@Override
	public List<Performance> listPerformanceOfCurrentAgent(String agentId) {
		return performanceRepository.findByAgentId(agentId);
	}

	@Override
	public Performance getPerformance(Long p) {

		return performanceRepository.findById(p).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void deletePerformance(Performance p) {
		performanceRepository.delete(p);

	}

	@Override
	public Performance addPerformance(Performance p) {
		Performance savedPerformance = performanceRepository.save(p);
		return savedPerformance;
	}

}
