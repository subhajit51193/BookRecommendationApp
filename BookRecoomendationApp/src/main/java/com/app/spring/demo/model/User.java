package com.app.spring.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "users",
uniqueConstraints = {
       @UniqueConstraint(columnNames = "username"),
       @UniqueConstraint(columnNames = "email")
    })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank
//	@Size(max = 20)
	private String username;
	
//	@NotBlank
//	@Size(max = 20)
//	@Email
	private String email;
	
//	@NotBlank
//	@Size(max = 20)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", 
	             joinColumns = @JoinColumn(name = "user_id"),
	             inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	@OneToMany(mappedBy = "user")
	private List<Book> books;
	
	public User() {
	  }

	  public User(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }
	  
	  

}
