package br.com.gabriel.cc.autor.service;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.entity.AuthorEntity;
import br.com.gabriel.cc.autor.repository.AuthorRepository;
import br.com.gabriel.cc.autor.service.exception.ValueDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	public static final String EMAIL_ALREADY_EXIST = "e-mail already exist";

	@Autowired
	private AuthorRepository authorRepository;

	public AuthorDTO saveAuthor(AuthorDTO dto) {
		checkDuplicatedEmail(dto);
		return new AuthorDTO(authorRepository.save(new AuthorEntity(dto)));
	}

	private void checkDuplicatedEmail(AuthorDTO dto) {
		if (authorRepository.findAuthorByEmail(dto.getEmail()) != null) {
			throw new ValueDuplicatedException(EMAIL_ALREADY_EXIST);
		}
	}
}
