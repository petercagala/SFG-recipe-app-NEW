package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDTO;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepositoryHibernate extends JpaRepository<CategoryDTO, Long> {

        public Optional<CategoryDTO> findByDescription(String description);

        public List<CategoryDTO> findAllByRecipeDTOS(RecipeDTO recipeDTO);
}
