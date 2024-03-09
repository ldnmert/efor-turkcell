package com.turkcellperf.repository;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.turkcellperf.entity.Performance;

public class PerformanceSpecifications {

	 public static Specification<Performance> filterByMemberId(String agentId) {
	        return (root, query, criteriaBuilder) -> {
	            if (agentId == null || agentId.isEmpty()) {
	                return criteriaBuilder.conjunction();
	            }
	            return criteriaBuilder.equal(root.get("agentId"), agentId);
	        };
	    }

	    public static Specification<Performance> filterByDateRange(Date startDate, Date endDate) {
	        return (root, query, criteriaBuilder) -> {
	            if (startDate == null || endDate == null) {
	                return criteriaBuilder.conjunction();
	            }
	            return criteriaBuilder.between(root.get("dateInfo"), startDate, endDate);
	        };
	    }
	
}
