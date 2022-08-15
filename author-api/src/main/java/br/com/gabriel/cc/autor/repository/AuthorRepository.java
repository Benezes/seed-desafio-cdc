package br.com.gabriel.cc.autor.repository;

import br.com.gabriel.cc.autor.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    AuthorEntity findAuthorByEmail(String email);
}
