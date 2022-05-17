package br.com.gabriel.cc.autor.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.gabriel.cc.autor.dto.AutorDTO;

@Entity
@Table(name = "tb_autor")
public class AutorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String descrição;
	private LocalDateTime registro = LocalDateTime.now();

	public AutorEntity() {
		super();
	}

	public AutorEntity(AutorDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.email = dto.getEmail();
		this.descrição = dto.getDescrição();
		this.registro = dto.getRegistro();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescrição() {
		return descrição;
	}

	public LocalDateTime getRegistro() {
		return registro;
	}

	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}

}
