package br.com.gabriel.cc.autor.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gabriel.cc.autor.entity.BookEntity;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "the field name is mandatory")
	private String title;

	@Size(max = 500, message = "the resume field must contain up to 500 characters")
	private String resume;
	private String summary;

	private Double price;

	private Integer totalPages;

	private String isbn;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publishDate;

	@NotNull(message = "the field name is mandatory")
	private String categories;

	@NotNull(message = "the field name is mandatory")
	private String author;

	public BookDTO() {
		super();
	}

	public BookDTO(BookEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.resume = entity.getResume();
		this.summary = entity.getSummary();
		this.price = entity.getPrice();
		this.totalPages = entity.getTotalPages();
		this.isbn = entity.getIsbn();
		this.publishDate = entity.getPublishDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
