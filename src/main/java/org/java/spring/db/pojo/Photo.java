package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String url;

	@Column
	private boolean visible;

	@ManyToMany(cascade = CascadeType.REMOVE)
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
	
	

	public List<Category> getCategories() {
		return categories;
	}

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
