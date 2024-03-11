package com.turkcellperf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.turkcellperf.entity.Agent;
import com.turkcellperf.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long>, JpaSpecificationExecutor<Performance> {
	
	List<Performance> findByAgentId(String agentid);

}
