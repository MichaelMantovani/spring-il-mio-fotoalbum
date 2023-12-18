package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 60)
	@Length(min = 5, message = "The title must be at least 5 characters")
	@NotBlank(message = "There must be at least one title")
	private String title;

	@Column(columnDefinition = "TEXT")
	@Length(min = 5, max = 150, message = "The description must contain between 5 and 150 characters")
	private String description;

	@Column
	@URL(protocol = "https", message = "The link must be in the https protocol")
	@NotBlank(message = "There must be a URL for the photo")
	private String url;

	@Column
	private boolean visible;

	@ManyToMany
	private List<Category> categories;

	public Photo() {
	}

	public Photo(String title, String description, String url, boolean visible, Category...categories) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
	
	
	@JsonProperty("categories")
	public List<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	private void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void setCategories(Category...categories) {
		setCategories(Arrays.asList(categories));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ id: " + getId() + "]: " + getTitle();
	}

}
