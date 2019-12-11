package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;

@Repository
public interface RecipeRepositoryHibernate extends JpaRepository<RecipeDTO, Long> {
}
