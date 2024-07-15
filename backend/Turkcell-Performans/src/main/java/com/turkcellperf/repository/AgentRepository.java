package com.turkcellperf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcellperf.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

	public Agent findByAgentId(String agentid);

}
