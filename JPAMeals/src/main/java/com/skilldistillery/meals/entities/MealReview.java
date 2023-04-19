package com.skilldistillery.meals.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class MealReview {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String comment;
	
	private int stars;
	
	private boolean enabled;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	//@MapsId(value="userId")
//	private User user;
//	
//	@ManyToOne
//	@JoinColumn(name = "meal_id")
//	//@MapsId(value="mealId")
//	private Meal meal;
//	
	public MealReview() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Meal getMeal() {
//		return meal;
//	}
//
//	public void setMeal(Meal meal) {
//		this.meal = meal;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealReview other = (MealReview) obj;
		return id == other.id;
	}

//	@Override
//	public String toString() {
//		return "MealReview [id=" + id + ", comment=" + comment + ", stars=" + stars + ", enabled=" + enabled
//				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", user=" + user + ", meal=" + meal + "]";
//	}
	
	

}