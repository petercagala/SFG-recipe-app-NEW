package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesService;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepService notesRepService;

    public NotesServiceImpl(NotesRepService notesRepService) {
        this.notesRepService = notesRepService;
    }

    @Override
    public List<Notes> findAll() {
        return this.notesRepService.findAll();
    }

    @Override
    public Notes findById(Long id) {
        return this.notesRepService.findById(id);
    }

    @Override
    public Notes findByRecipe(Recipe recipe) {
        return this.notesRepService.findByRecipe(recipe);
    }

    @Override
    public Notes save(Notes notes) {
        return this.notesRepService.save(notes);
    }

    @Override
    public void delete(Notes notes) {
        this.notesRepService.delete(notes);
    }

    @Override
    public void deleteById(Long id) {
        this.notesRepService.deleteById(id);
    }
}
