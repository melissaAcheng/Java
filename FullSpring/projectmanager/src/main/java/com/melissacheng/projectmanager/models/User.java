package com.melissacheng.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="*required")
	@Size(min=3, max=30, message="First name must be at least 3 characters")
	@Pattern(regexp="^[a-zA-Z]+$", message="First name must only include letters")
	private String firstName;
	
	@NotEmpty(message="*required")
	@Size(min=3, max=30, message="Username must be at least 3 characters")
	@Pattern(regexp="^[a-zA-Z]+$", message="Last name must only include letters")
	private String lastName;
	
	@NotEmpty(message="*required")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="*required")
	@Size(min=8, max=128, message="Password must be at least 8 characters")
	private String password;
	
	@Transient
	@NotEmpty(message="*required")
	@Size(min=8, max=128, message="Confirm password must be at least 8 characters")
	private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProjectUser> ProjectUser;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Task> Task;
	
	@OneToMany(mappedBy="teamLead", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Project> Project;
	
	public User() {
		
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<ProjectUser> getProjectUser() {
		return ProjectUser;
	}

	public void setProjectUser(List<ProjectUser> projectUser) {
		ProjectUser = projectUser;
	}

	public List<Task> getTask() {
		return Task;
	}

	public void setTask(List<Task> task) {
		Task = task;
	}

	public List<Project> getProject() {
		return Project;
	}

	public void setProject(List<Project> project) {
		Project = project;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
