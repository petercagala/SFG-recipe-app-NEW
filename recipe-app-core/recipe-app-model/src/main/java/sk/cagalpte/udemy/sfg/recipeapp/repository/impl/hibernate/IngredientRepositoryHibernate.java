package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDTO;

@Repository
public interface IngredientRepositoryHibernate extends JpaRepository<IngredientDTO, Long> {
}
