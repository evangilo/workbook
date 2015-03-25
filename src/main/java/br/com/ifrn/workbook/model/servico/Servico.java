package br.com.ifrn.workbook.model.servico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.ifrn.workbook.model.BaseEntity;
import br.com.ifrn.workbook.model.user.UserAccount;

@Entity
public class Servico extends BaseEntity<Long>{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Long id;

	@Column(nullable = false)
	private String titulo;

	@ManyToOne @JoinColumn
	private UserAccount usuario;
	
	@ManyToOne @JoinColumn(name = "categoria",nullable = false)
	private Categoria categoria;
	
	/*@ManyToOne @JoinColumn(name= "cidade",nullable = false)
	private Cidade cidade;*/
	
	private String descricao;
	
	private String telefone;
	
	private String celular;
	
	@Lob	
	private byte[] image;
	
	private int media;
	
	private int total;
	
	private boolean patrocinado;
	
	public Servico() {
	}

	public Servico(String titulo) {
		this.titulo = titulo;
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public boolean isPatrocinado() {
		return patrocinado;
	}

	public void setPatrocinado(boolean patrocinado) {
		this.patrocinado = patrocinado;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	/*public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}*/

}
