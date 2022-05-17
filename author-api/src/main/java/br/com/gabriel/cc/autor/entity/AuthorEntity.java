package br.com.gabriel.cc.autor.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.gabriel.cc.autor.dto.AuthorDTO;

@Entity
@Table(name = "tb_autor")
public class AuthorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String description;
	private LocalDateTime record = LocalDateTime.now();

	public AuthorEntity() {
		super();
	}

	public AuthorEntity(AuthorDTO dto) {
		this.id = dto.getId();
		this.name = dto.getNome();
		this.email = dto.getEmail();
		this.description = dto.getDescrição();
		this.record = dto.getRegistro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescrição() {
		return description;
	}

	public LocalDateTime getRegistro() {
		return record;
	}

	public void setRegistro(LocalDateTime registro) {
		this.record = registro;
	}

}
