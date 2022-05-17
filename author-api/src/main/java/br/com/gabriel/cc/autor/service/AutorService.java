package br.com.gabriel.cc.autor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.cc.autor.dto.AutorDTO;
import br.com.gabriel.cc.autor.entity.AutorEntity;
import br.com.gabriel.cc.autor.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository authorRepository;

	public AutorDTO salvarAutor(AutorDTO dto) {
		return new AutorDTO(authorRepository.save(new AutorEntity(dto)));
	}
}
