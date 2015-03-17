package br.com.ifrn.workbook.model.servico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.ifrn.workbook.model.BaseEntity;

@Entity
public class Categoria extends BaseEntity<Long> {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@Column(nullable = false)
	private String nome;

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
}
