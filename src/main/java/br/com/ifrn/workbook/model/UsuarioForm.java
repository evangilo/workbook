package br.com.ifrn.workbook.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioForm {
	
	@NotEmpty private String nome;
	@NotEmpty private String username = "";
	@NotEmpty private String password = "";
	@NotEmpty private String email = "";

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
}
