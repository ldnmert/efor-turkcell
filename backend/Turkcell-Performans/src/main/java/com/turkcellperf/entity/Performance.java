package com.turkcellperf.entity;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="performance")
@Getter
@Setter
public class Performance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "AGENTID")
	private String agentId;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "BEGIN")
	@JsonFormat(pattern = "HH:mm")
	private Timestamp begin;
	
	@Column(name = "END")
	@JsonFormat(pattern = "HH:mm")
	private Timestamp end;
	
	@Column(name = "DATEINFO")
	private Date dateInfo;
	
	@Column(name = "EXECUSE")
	private String execuse;
	
	@Column(name = "EXECUSEHOURS")
	private Integer execuseHours;
	
	@Column(name = "TIMEOUT")
	private Integer timeout;
	
}
