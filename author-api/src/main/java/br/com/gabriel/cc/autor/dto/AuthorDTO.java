package br.com.gabriel.cc.autor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gabriel.cc.autor.entity.AuthorEntity;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "the field name is mandatory")
	private String name;

	@NotBlank(message = "the field email is mandatory")
	@Email(message = "insert a valid email")
	private String email;

	@NotBlank(message = "the field description is mandatory")
	@Size(max = 400, message = "the description field must contain up to 400 characters")
	private String description;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime record = LocalDateTime.now();

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(AuthorEntity entity) {
		this.id = entity.getId();
		this.name = entity.getNome();
		this.email = entity.getEmail();
		this.description = entity.getDescrição();
		this.record = entity.getRegistro();
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

	public void setDescrição(String descrição) {
		this.description = descrição;
	}

	public LocalDateTime getRegistro() {
		return record;
	}

	public void setRegistro(LocalDateTime registro) {
		this.record = registro;
	}

}
