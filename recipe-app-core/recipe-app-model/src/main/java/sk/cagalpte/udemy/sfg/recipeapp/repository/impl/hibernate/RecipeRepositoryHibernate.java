package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDTO;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;

import java.util.List;

@Repository
public interface RecipeRepositoryHibernate extends JpaRepository<RecipeDTO, Long> {

    public List<RecipeDTO> findAllByCategoryDTOS(CategoryDTO categoryDTO);
}
