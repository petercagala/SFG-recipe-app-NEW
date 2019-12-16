package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDTO;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;

import java.util.List;

@Repository
public interface IngredientRepositoryHibernate extends JpaRepository<IngredientDTO, Long> {
    public List<IngredientDTO> findAllByRecipeDTO(RecipeDTO recipeDTO);
}
