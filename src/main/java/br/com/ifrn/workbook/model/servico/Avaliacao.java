package br.com.ifrn.workbook.model.servico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ifrn.workbook.model.BaseEntity;
import br.com.ifrn.workbook.model.user.UserAccount;

@Entity
public class Avaliacao extends BaseEntity<Long>{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "avaliacao_id")
	private Long id;
	
	@Column(nullable = false)	
	private String comentario;
	
	@ManyToOne @JoinColumn(name = "id_usuario")
	private UserAccount usuario;
	
	@ManyToOne @JoinColumn(name = "id_servico")
	private Servico servico;

	private int nota;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserAccount getUsuario() {
		return usuario;
	}

	public void setUsuario(UserAccount usuario) {
		this.usuario = usuario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
