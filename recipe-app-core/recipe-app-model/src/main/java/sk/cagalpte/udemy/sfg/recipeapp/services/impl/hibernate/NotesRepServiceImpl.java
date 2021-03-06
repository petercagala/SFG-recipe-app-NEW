package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.NotesDto;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.NotesDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.NotesRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.RecipeRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.services.NotesRepService;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Service
public class NotesRepServiceImpl implements NotesRepService {

    private final NotesRepositoryHibernate notesRepositoryHibernate;

    private final NotesDtoMapper notesDtoMapper;

    private final RecipeDtoMapper recipeDtoMapper;

    private final RecipeRepositoryHibernate recipeRepositoryHibernate;

    public NotesRepServiceImpl(NotesRepositoryHibernate notesRepositoryHibernate, NotesDtoMapper notesDtoMapper, RecipeDtoMapper recipeDtoMapper, RecipeRepositoryHibernate recipeRepositoryHibernate) {
        this.notesRepositoryHibernate = notesRepositoryHibernate;
        this.notesDtoMapper = notesDtoMapper;
        this.recipeDtoMapper = recipeDtoMapper;
        this.recipeRepositoryHibernate = recipeRepositoryHibernate;
    }

    @Override
    public List<Notes> findAll() {
        List<Notes> notes = this.notesRepositoryHibernate.findAll().stream()
                .map(notesDTO -> {
                    return this.notesDtoMapper.notesDtoToNotes(notesDTO);
                }).collect(Collectors.toList());
        return notes;
    }

    @Override
    public Notes findById(Long id) {
        return this.notesDtoMapper.notesDtoToNotes(this.notesRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public Notes findByRecipe(Recipe recipe) {
        RecipeDto recipeDTO = this.recipeRepositoryHibernate.findById(recipe.getId()).orElse(null);
        NotesDto notesDTO = this.notesRepositoryHibernate.findByRecipeDTO(recipeDTO);
        return this.notesDtoMapper.notesDtoToNotes(notesDTO);
    }

    @Override
    public Notes save(Notes notes) {
        NotesDto notesDTO = new NotesDto().createBuilder()
                .recipeNotes(notes.getRecipeNotes())
                .recipeDTO(this.recipeRepositoryHibernate.findById(notes.getRecipe().getId()).orElse(null))
                .build();
        NotesDto notesDtoSaved = this.notesRepositoryHibernate.save(notesDTO);
        return this.notesDtoMapper.notesDtoToNotes(notesDtoSaved);
    }

    @Override
    public void delete(Notes notes) {
        this.notesRepositoryHibernate.delete(this.notesDtoMapper.notesToNotesDto(notes));
    }

    @Override
    public void deleteById(Long id) {
        this.notesRepositoryHibernate.deleteById(id);
    }
}
