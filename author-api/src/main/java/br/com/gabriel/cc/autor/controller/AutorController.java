package br.com.gabriel.cc.autor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.cc.autor.dto.AutorDTO;
import br.com.gabriel.cc.autor.service.AutorService;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping
	public ResponseEntity<AutorDTO> save(@RequestBody @Valid AutorDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(autorService.salvarAutor(dto));
	}
}
