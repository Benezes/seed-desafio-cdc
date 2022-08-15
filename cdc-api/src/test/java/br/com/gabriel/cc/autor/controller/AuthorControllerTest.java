package br.com.gabriel.cc.autor.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gabriel.cc.autor.dto.AuthorDTO;
import br.com.gabriel.cc.autor.factory.FactoryAuthor;
import br.com.gabriel.cc.autor.service.AuthorService;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

	private static final String END_POINT = "/authors";

	private AuthorDTO authorDto = FactoryAuthor.buildAuthorDTO();

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorService authorService;

	@BeforeEach
	void setUp() throws Exception {
		when(authorService.saveAuthor(any(AuthorDTO.class))).thenReturn(authorDto);
	}

	@Test
	void shouldInsertAuthorInControllerWithSuccess() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(authorDto);

		mockMvc //
				.perform(post(END_POINT) //
						.content(jsonBody).contentType(MediaType.APPLICATION_JSON) //
						.accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(jsonPath("$.name").exists());
	}

	@Test
	void shouldInsertAuthorInControllerWithError() throws Exception {
		authorDto.setName("");
		String jsonBody = objectMapper.writeValueAsString(authorDto);

		mockMvc //
				.perform(post(END_POINT) //
						.content(jsonBody).contentType(MediaType.APPLICATION_JSON) //
						.accept(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isUnprocessableEntity());
	}

}
