package org.java.spring.db.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Length(min = 4, message = "The title must be at least 4 characters")
	@NotBlank(message = "There must be at least one name")
	private String name;
	
	@Column
	@NotBlank(message = "There must be a color for the category")
	private String color;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Photo> photos;
	
	public Category() {}
	
	public Category(String name, String color) {
		setName(name);
		setColor(color);
	}
	
	

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "[ id: " + getId() + "]" + "Name: " + getName();
	}
}
