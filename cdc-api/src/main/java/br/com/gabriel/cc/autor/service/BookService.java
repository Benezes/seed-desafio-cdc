package br.com.gabriel.cc.autor.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cc.autor.dto.BookDTO;
import br.com.gabriel.cc.autor.entity.AuthorEntity;
import br.com.gabriel.cc.autor.entity.BookEntity;
import br.com.gabriel.cc.autor.entity.CategoryEntity;
import br.com.gabriel.cc.autor.repository.AuthorRepository;
import br.com.gabriel.cc.autor.repository.BookRepository;
import br.com.gabriel.cc.autor.repository.CategoryRepository;
import br.com.gabriel.cc.autor.service.exception.ValueDuplicatedException;
import br.com.gabriel.cc.autor.service.exception.ValueNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AuthorRepository authorRepository;

	public BookDTO saveBook(BookDTO dto) {
		checkDuplicatedValues(dto);
		CategoryEntity category = categoryRepository.findByNameCategory(dto.getCategories())
				.orElseThrow(() -> new ValueNotFoundException("Category not found"));
		AuthorEntity author = authorRepository.findByName(dto.getAuthor())
				.orElseThrow(() -> new ValueNotFoundException("Author not found"));

		BookEntity bookEntity = buildBookEntity(dto, category, author);

		return buildBookDTO(category, author, bookEntity);
	}

	public List<BookDTO> findAllBooks() {
		return bookRepository.findAll().stream().map(BookDTO::new).collect(Collectors.toList());
	}

	public BookDTO findBookById(Long id) {
		return new BookDTO(bookRepository.findById(id).orElseThrow(() -> new ValueNotFoundException("Id not found")));
	}

	private BookEntity buildBookEntity(BookDTO dto, CategoryEntity category, AuthorEntity author) {
		BookEntity bookEntity = new BookEntity(dto);
		bookEntity.setCategories(Arrays.asList(category));
		bookEntity.setAuthors(Arrays.asList(author));
		return bookEntity;
	}

	private BookDTO buildBookDTO(CategoryEntity category, AuthorEntity author, BookEntity bookEntity) {
		BookDTO bookDTO = new BookDTO(bookRepository.save(bookEntity));
		bookDTO.setAuthor(author.getName());
		bookDTO.setCategories(category.getNameCategory());
		return bookDTO;
	}

	private void checkDuplicatedValues(BookDTO dto) {
		checkTitle(dto);
		checkIsbn(dto);
	}

	private void checkTitle(BookDTO dto) {
		if (bookRepository.findBookByTitle(dto.getTitle()) != null) {
			throw new ValueDuplicatedException("This title already exist");
		}
	}

	private void checkIsbn(BookDTO dto) {
		if (bookRepository.findBookByIsbn(dto.getIsbn()) != null) {
			throw new ValueDuplicatedException("This isbn already exist");
		}
	}

}
