package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepositoryHibernate extends JpaRepository<CategoryDto, Long> {

        public Optional<CategoryDto> findByDescription(String description);

        public List<CategoryDto> findAllByRecipeDTOS(RecipeDto recipeDTO);
}
