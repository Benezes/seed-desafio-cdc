package br.com.gabriel.cc.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.entity.AuthorEntity;
import br.com.gabriel.cc.autor.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public AuthorDTO saveAuthor(AuthorDTO dto) {
		return new AuthorDTO(authorRepository.save(new AuthorEntity(dto)));
	}
}
