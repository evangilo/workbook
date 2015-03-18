package br.com.ifrn.workbook.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.ifrn.workbook.model.user.UserAccount;

@Entity
public class PasswordResetToken {

	private static final int EXPIRATION = 60 * 24; // 24 hours

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pass_reset_token_id", nullable = false)
	private Long id;

	@OneToOne(targetEntity = UserAccount.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private UserAccount user;

	private String token;

	private Date expiryDate;

	public PasswordResetToken() {
	}

	public PasswordResetToken(String token, UserAccount user) {
		this.token = token;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@PrePersist
	public void prePersist() {
		expiryDate = calculateExpiryDate();
	}

	@PreUpdate
	public void preUpdate() {
		expiryDate = calculateExpiryDate();
	}

	private Date calculateExpiryDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, EXPIRATION);
		return new Date(calendar.getTime().getTime());
	}
}
