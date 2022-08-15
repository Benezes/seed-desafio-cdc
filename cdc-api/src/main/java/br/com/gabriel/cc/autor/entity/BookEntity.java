package br.com.gabriel.cc.autor.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.gabriel.cc.autor.dto.BookDTO;

@Entity
@Table(name = "tb_book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String resume;
	private String summary;
	private Double price;
	private Integer totalPages;
	private String isbn;
	private LocalDate publishDate;

	@OneToMany(mappedBy = "book")
	private List<CategoryEntity> categories = new ArrayList<>();

	@OneToMany(mappedBy = "book")
	private List<AuthorEntity> authors = new ArrayList<>();

	public BookEntity() {
		super();
	}

	public BookEntity(BookDTO dto) {
		this.id = dto.getId();
		this.title = dto.getTitle();
		this.resume = dto.getSummary();
		this.summary = dto.getSummary();
		this.price = dto.getPrice();
		this.totalPages = dto.getTotalPages();
		this.isbn = dto.getIsbn();
		this.publishDate = dto.getPublishDate();
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

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}

}
