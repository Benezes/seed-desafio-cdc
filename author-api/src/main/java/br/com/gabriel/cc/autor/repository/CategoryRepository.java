package br.com.gabriel.cc.autor.repository;

import br.com.gabriel.cc.autor.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    CategoryEntity findCategoryByNameCategory(String category);
}
