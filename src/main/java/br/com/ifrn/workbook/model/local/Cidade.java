package br.com.ifrn.workbook.model.local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ifrn.workbook.model.BaseEntity;

@Entity
public class Cidade extends BaseEntity<Long> {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String estado;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
