package br.com.gabriel.cc.autor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public ResponseEntity<AuthorDTO> save(@RequestBody @Valid AuthorDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(authorService.salvarAuthor(dto));
	}
}
