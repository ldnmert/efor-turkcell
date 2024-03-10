package com.turkcellperf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agent")
@Getter
@Setter
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "AGENTID")
	private String agentId;
	
	@Column(name = "PASSWORD")
	private String password;
	

	@Column(name = "ROLE")
	private String roleName;
	
	@Column(name = "PHOTO")
	private String photo;
	
	@Column(name = "NAME")
	private String firstName;
	
	@Column(name = "SURNAME")
	private String surname;
	
	
}
