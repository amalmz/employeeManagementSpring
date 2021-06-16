package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name ;
	private String last_name ;
	@Size(max = 20)
	private String username;

	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 120)
	private String password;

	private String jobTitle;
	private String phone;
	private String imageUrl;
	private String employeeCode;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password , String first_name, String last_name) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.first_name=first_name;
		this.last_name=last_name;
	}


	public User(String first_name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
		this.first_name = first_name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.employeeCode = employeeCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    public String getFirst_name(){
		return first_name ;
	}
	public String setFirst_name(String first_name){
		return this.first_name = first_name;
	}
	public String getLast_name(){
		return last_name ;
	}
	public String setLast_name(String last_name ){
		return this.last_name = last_name;
	}


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + first_name + '\'' +
				", email='" + email + '\'' +
				", jobTitle='" + jobTitle + '\'' +
				", phone='" + phone + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				'}';
	}

}
