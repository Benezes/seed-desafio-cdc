package br.com.gabriel.cc.autor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.entity.AuthorEntity;
import br.com.gabriel.cc.autor.factory.FactoryAuthor;
import br.com.gabriel.cc.autor.repository.AuthorRepository;

@ExtendWith(SpringExtension.class)
@DisplayName(value = "Author Service Test")
class AuthorServiceTest {

	private AuthorEntity authorEntity = FactoryAuthor.buildAuthorEntity();
	private AuthorDTO dto = FactoryAuthor.buildAuthorDTO();

	@Mock
	private AuthorRepository authorRepository;

	@InjectMocks
	private AuthorService authorService;

	@BeforeEach
	void setUp() {
		when(authorRepository.save(any(AuthorEntity.class))).thenReturn(authorEntity);
	}

	@Test
	void shouldInsertAuthorWithSuccess() {
		AuthorDTO result = authorService.saveAuthor(dto);
		assertNotNull(result);
		assertNotNull(dto.getRecord());
		assertNotNull(dto.getName());
		assertEquals(authorEntity.getName(), dto.getName());
		assertEquals(authorEntity.getEmail(), dto.getEmail());
	}

}
