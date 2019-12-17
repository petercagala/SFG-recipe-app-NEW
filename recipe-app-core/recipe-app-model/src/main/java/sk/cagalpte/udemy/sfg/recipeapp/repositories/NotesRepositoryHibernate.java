package sk.cagalpte.udemy.sfg.recipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.dto.NotesDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;

@Repository
public interface NotesRepositoryHibernate extends JpaRepository<NotesDto, Long> {

    public NotesDto findByRecipeDTO(RecipeDto recipeDTO);

}
