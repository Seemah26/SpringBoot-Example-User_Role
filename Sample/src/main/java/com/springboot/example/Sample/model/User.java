package com.springboot.example.Sample.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	// private String roleName;

	private boolean isActive;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = {
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private Set<Role> roles;

}
