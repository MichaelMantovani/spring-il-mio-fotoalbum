package org.java.spring.db.pojo;

import org.java.spring.auth.db.pojo.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "messagge")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "TEXT")
	@NotBlank
	private String message;
	
	
	@Column
	@NotBlank
	private String email;
	
	@Column
	@NotBlank
	private String name;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	public Message() {}
	
	public Message(String message, String email, String name, User user) {
		setMessage(message);
		setEmail(email);
		setName(name);
		setUser(user);
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getShortMessage() {
		int maxLength = 60; 

        if (message.length() > maxLength) {
            return message.substring(0, maxLength) + "...";
        } else {
            return message;
        }
	}
	
	
	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
