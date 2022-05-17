package br.com.gabriel.cc.autor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gabriel.cc.autor.entity.AutorEntity;

public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "o campo nome é obrigatório")
	private String nome;

	@NotNull(message = "o campo email é obrigatório")
	@Email(message = "")
	private String email;

	@NotNull(message = "o campo descrição é obrigatório")
	@Size(max = 400, message = "")
	private String descrição;

	@JsonFormat(pattern = "dd/MM/yyyy  HH:mm:ss")
	private LocalDateTime registro = LocalDateTime.now();

	public AutorDTO() {
		super();
	}

	public AutorDTO(AutorEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.descrição = entity.getDescrição();
		this.registro = entity.getRegistro();
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

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public LocalDateTime getRegistro() {
		return registro;
	}

	public void setRegistro(LocalDateTime registro) {
		this.registro = registro;
	}

}
