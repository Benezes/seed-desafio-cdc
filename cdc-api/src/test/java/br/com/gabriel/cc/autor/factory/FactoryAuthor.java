package br.com.gabriel.cc.autor.factory;

import java.time.LocalDateTime;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.entity.AuthorEntity;

public class FactoryAuthor {

	public static AuthorEntity buildAuthorEntity() {
		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.setName("Maria");
		authorEntity.setEmail("maria@gmail.com");
		authorEntity.setDescription("guten morgen");
		authorEntity.setRecord(LocalDateTime.now());
		return authorEntity;
	}

	public static AuthorDTO buildAuthorDTO() {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setName("Maria");
		authorDTO.setEmail("maria@gmail.com");
		authorDTO.setDescription("guten morgen");
		authorDTO.setRecord(LocalDateTime.now());
		return authorDTO;
	}

}
