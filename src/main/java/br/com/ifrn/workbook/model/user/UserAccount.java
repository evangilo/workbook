package br.com.ifrn.workbook.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.com.ifrn.workbook.model.BaseEntity;

@Entity
@Table(name = "user_account")
public class UserAccount extends BaseEntity<Long> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Long id;	

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	/*@Column(name = "username", nullable = false, unique = true)
	private String username;*/

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false, unique = true)
	private String email;	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20, nullable = false)
	private Role role;
	
	@Column(name = "active")
	private boolean active;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sign_in_provider", length = 20)
	private SocialMediaService signInProvider;
	
	public UserAccount() { }

	@Override
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

	/*public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public SocialMediaService getSignInProvider() {
		return signInProvider;
	}

	public void setSignInProvider(SocialMediaService signInProvider) {
		this.signInProvider = signInProvider;
	}
	
	@Override
	public String toString() {	
		return String.format("%s %s", firstName, lastName);
	}
	
	@Override
	@PrePersist
	protected void prePersist() {
		this.active = true;
		super.prePersist();
	}
	
}
