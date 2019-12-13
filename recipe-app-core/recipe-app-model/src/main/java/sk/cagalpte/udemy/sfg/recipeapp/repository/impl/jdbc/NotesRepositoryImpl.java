package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.NotesRepository;

import java.util.List;

@Profile("jdbc")
@Repository
public class NotesRepositoryImpl implements NotesRepository {
    @Override
    public List<Notes> findAll() {
        return null;
    }

    @Override
    public Notes findById(Long id) {
        return null;
    }

    @Override
    public Notes findByRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Notes save(Notes notes) {
        return null;
    }

    @Override
    public void delete(Notes notes) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
