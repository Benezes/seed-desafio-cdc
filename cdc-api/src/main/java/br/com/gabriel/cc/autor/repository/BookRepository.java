package br.com.gabriel.cc.autor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.cc.autor.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	BookEntity findBookByTitle(String title);

	BookEntity findBookByIsbn(String isbn);

}
