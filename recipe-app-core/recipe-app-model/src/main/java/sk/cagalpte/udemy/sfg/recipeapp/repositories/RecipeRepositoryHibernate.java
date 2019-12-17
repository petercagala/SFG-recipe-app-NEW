package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;

import java.util.List;

@Repository
public interface RecipeRepositoryHibernate extends JpaRepository<RecipeDto, Long> {

    public List<RecipeDto> findAllByCategoryDTOS(CategoryDto categoryDTO);
}
