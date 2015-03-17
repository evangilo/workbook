package br.com.ifrn.workbook.model.servico;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ifrn.workbook.model.BaseEntity;

@Entity
public class Destaque extends BaseEntity<Long> {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "destaque_id")
	private Long id;

	@ManyToOne @JoinColumn(name = "servico", nullable = false)
	private Servico servico;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date atualizado;

	private int tempo;
	
	private int situacao;

	@PrePersist
	private void onPrePersist() {
		this.atualizado = new Date();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Date getAtualizado() {
		return atualizado;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public void setAtualizado(Date atualizado) {
		this.atualizado = atualizado;
	}
}
