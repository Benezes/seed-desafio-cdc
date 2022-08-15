package br.com.gabriel.cc.autor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.cc.autor.dto.BookDTO;
import br.com.gabriel.cc.autor.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<BookDTO> save(@RequestBody @Valid BookDTO dto) {
		return ResponseEntity.ok(bookService.saveBook(dto));
	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll() {
		return ResponseEntity.ok(bookService.findAllBooks());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findBookById(id));
	}
}
