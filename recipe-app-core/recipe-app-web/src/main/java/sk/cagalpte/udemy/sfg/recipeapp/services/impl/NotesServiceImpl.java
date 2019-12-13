package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.repository.NotesRepository;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesService;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<Notes> findAll() {
        return this.notesRepository.findAll();
    }

    @Override
    public Notes findById(Long id) {
        return this.notesRepository.findById(id);
    }

    @Override
    public Notes findByRecipe(Recipe recipe) {
        return this.notesRepository.findByRecipe(recipe);
    }

    @Override
    public Notes save(Notes notes) {
        return this.notesRepository.save(notes);
    }

    @Override
    public void delete(Notes notes) {
        this.notesRepository.delete(notes);
    }

    @Override
    public void deleteById(Long id) {
        this.notesRepository.deleteById(id);
    }
}
