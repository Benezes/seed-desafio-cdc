package br.com.gabriel.cc.autor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.cc.autor.entity.AutorEntity;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {

}
