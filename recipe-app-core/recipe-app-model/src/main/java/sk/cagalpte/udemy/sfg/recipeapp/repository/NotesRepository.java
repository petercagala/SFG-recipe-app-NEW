package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

@Repository
public interface NotesRepository extends MapRepository<Notes, Long> {

    public Notes findByRecipe(Recipe recipe);
}
