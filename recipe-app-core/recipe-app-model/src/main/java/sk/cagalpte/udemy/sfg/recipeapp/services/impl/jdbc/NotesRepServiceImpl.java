package sk.cagalpte.udemy.sfg.recipeapp.services.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesRepService;

import java.util.List;

@Profile("jdbc")
@Service
public class NotesRepServiceImpl implements NotesRepService {
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
