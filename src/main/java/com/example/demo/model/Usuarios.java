package com.example.demo.model;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private Number phoned; 
	
	@CreationTimestamp
	private Date createdAt;
	
	@CreationTimestamp
	private Date updatedAt;
	
	@CreationTimestamp
	private Date lastLogin;
	
	
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Number getPhoned() {
		return phoned;
	}
	public void setPhoned(Number phoned) {
		this.phoned = phoned;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


}
