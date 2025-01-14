package br.com.gabriel.cc.autor.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gabriel.cc.autor.dto.AuthorDTO;

@Entity
@Table(name = "tb_author")
public class AuthorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String description;
	private LocalDateTime record = LocalDateTime.now();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private BookEntity book;

	public AuthorEntity() {
		super();
	}

	public AuthorEntity(AuthorDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.description = dto.getDescription();
		this.record = dto.getRecord();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getRecord() {
		return record;
	}

	public void setRecord(LocalDateTime record) {
		this.record = record;
	}

	public BookEntity getBook() {
		return book;
	}

}
