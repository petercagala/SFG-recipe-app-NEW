package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;

import java.util.List;

@Repository
public interface IngredientRepositoryHibernate extends JpaRepository<IngredientDto, Long> {
    public List<IngredientDto> findAllByRecipeDTO(RecipeDto recipeDTO);
}
