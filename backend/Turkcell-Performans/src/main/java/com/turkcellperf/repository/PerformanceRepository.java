package com.turkcellperf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcellperf.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	

}
