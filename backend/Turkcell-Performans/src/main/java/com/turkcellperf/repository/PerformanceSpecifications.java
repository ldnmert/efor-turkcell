package com.turkcellperf.repository;

import java.sql.Timestamp;
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
	    
//	    public static Specification<Performance> filterByTimestampRange(Timestamp begin, Timestamp end) {
//	       
//	    	
//	    	return (root, query, criteriaBuilder) -> {
//	    		
//	    		
//	    		System.out.println(begin + "qwewqe" + end + "ddddddd");
//
//	            if (begin == null || end == null) {
//	                return criteriaBuilder.conjunction();
//	            }
//	            return criteriaBuilder.and(
//	                criteriaBuilder.greaterThan(root.get("begin"), begin),
//	                criteriaBuilder.lessThan(root.get("end"), end)
//	            );
//	        };
//	    }

	    public static Specification<Performance> filterByExcuse(String excuse) {
	        return (root, query, criteriaBuilder) -> {
	            if (excuse == null || excuse.isEmpty()) {
	                return criteriaBuilder.conjunction();
	            }
	            return criteriaBuilder.equal(root.get("excuse"), excuse);
	        };
	    }

	    public static Specification<Performance> filterByExcuseHours(Integer excuseHours) {
	        return (root, query, criteriaBuilder) -> {
	            if (excuseHours == null) {
	                return criteriaBuilder.conjunction();
	            }
	            return criteriaBuilder.equal(root.get("execuseHours"), excuseHours);
	        };
	    }

	    public static Specification<Performance> filterByTimeout(Integer timeout) {
	        return (root, query, criteriaBuilder) -> {
	            if (timeout == null) {
	                return criteriaBuilder.conjunction();
	            }
	            return criteriaBuilder.equal(root.get("timeout"), timeout);
	        };
	    }
	
}
