package br.com.gabriel.cc.autor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.cc.autor.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

	AuthorEntity findAuthorByEmail(String email);

	Optional<AuthorEntity> findByName(String author);
}
