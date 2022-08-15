package br.com.gabriel.cc.autor.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gabriel.cc.autor.dto.CategoryDTO;

@Entity
@Table(name = "tb_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private BookEntity book;

	public CategoryEntity(CategoryDTO categoryDTO) {
		this.id = categoryDTO.getId();
		this.nameCategory = categoryDTO.getNameCategory();
	}

	public CategoryEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public BookEntity getBook() {
		return book;
	}

}
