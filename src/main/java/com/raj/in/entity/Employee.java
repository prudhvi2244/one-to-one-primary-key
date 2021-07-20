package com.raj.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

	@Id
	@GeneratedValue(generator = "MyGenerator")
	@GenericGenerator(name = "MyGenerator",
	strategy = "foreign",parameters = {@Parameter(name="property",value = "account")})
	private Integer eid;
	@Column
	private String ename;
	@Column
	private String ecity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eid")
	private Account account;

}
