package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="t_user")
public class User {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_user ;
private String firstName;

private String lastName ;

private String email;

private String password;
private String roles;


 public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}

private Date date_de_naissance;

	public long getId_user() {
	return id_user;
}
public void setId_user(long id_user) {
	this.id_user = id_user;
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
public Date getDate_de_naissance() {
	return date_de_naissance;
}
public void setDate_de_naissance(Date date_de_naissance) {
	this.date_de_naissance = date_de_naissance;
}

public Set<Annonce> getAnnonces() {
	return annonces;
}
public void setAnnonces(Set<Annonce> annonces) {
	this.annonces = annonces;
}
public Set<Notifications> getNotifications() {
	return notifications;
}
public void setNotifications(Set<Notifications> notifications) {
	this.notifications = notifications;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	
	@OneToMany ( mappedBy="user")
	private Set<Annonce> annonces;
	@OneToMany (cascade= CascadeType.ALL , mappedBy="user")
	private Set<Notifications> notifications;


	public User(String firstName, String lastName, String email, String password, String roles,
			Date date_de_naissance, Set<Annonce> annonces, Set<Notifications> notifications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.date_de_naissance = date_de_naissance;
		this.annonces = annonces;
		this.notifications = notifications;
	}
	public User() {
		super();
	}
	
	
	



}
