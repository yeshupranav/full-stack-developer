package com.example.recepie.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
	@Table(name = "recipe")
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
	        allowGetters = true)
	public class Recipe {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String name;

	    private String instruction;

	    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	    private List<Ingredient> ingredients;

	    @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedAt;


	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getInstruction() {
	        return instruction;
	    }

	    public void setInstruction(String instruction) {
	        this.instruction = instruction;
	    }

	    public List<Ingredient> getIngredients() {
	        return ingredients;
	    }

	    public void setIngredients(List<Ingredient> ingredients) {
	        this.ingredients = ingredients;
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

	    @Override
	    public String toString() {
	        return "Recipe{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", instruction='" + instruction + '\'' +
	                ", ingredients=" + ingredients +
	                ", createdAt=" + createdAt +
	                ", updatedAt=" + updatedAt +
	                '}';
	    }
	}


