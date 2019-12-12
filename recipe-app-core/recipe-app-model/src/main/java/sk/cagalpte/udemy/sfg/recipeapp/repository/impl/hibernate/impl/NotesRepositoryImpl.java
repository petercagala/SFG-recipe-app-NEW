package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.dto.NotesDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.NotesDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.RecipeDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.NotesRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.NotesRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class NotesRepositoryImpl implements NotesRepository {

    private final NotesRepositoryHibernate notesRepositoryHibernate;

    private final NotesDtoMapper notesDtoMapper;

    private final RecipeDtoMapper recipeDtoMapper;

    public NotesRepositoryImpl(NotesRepositoryHibernate notesRepositoryHibernate, NotesDtoMapper notesDtoMapper, RecipeDtoMapper recipeDtoMapper) {
        this.notesRepositoryHibernate = notesRepositoryHibernate;
        this.notesDtoMapper = notesDtoMapper;
        this.recipeDtoMapper = recipeDtoMapper;
    }

    @Override
    public List<Notes> findAll() {
        List<Notes> notes = this.notesRepositoryHibernate.findAll().stream()
                .map(notesDTO -> {
                    return this.notesDtoMapper.notesDTOtoNotes(notesDTO);
                }).collect(Collectors.toList());
        return notes;
    }

    @Override
    public Notes findById(Long id) {
        return this.notesDtoMapper.notesDTOtoNotes(this.notesRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public Notes save(Notes notes) {
        NotesDTO notesDTO = new NotesDTO().createBuilder()
                .recipeNotes(notes.getRecipeNotes())
                .recipeDTO(this.recipeDtoMapper.recipeToRecipeDTO(notes.getRecipe()))
                .build();
        NotesDTO notesDtoSaved = this.notesRepositoryHibernate.save(notesDTO);
        return this.notesDtoMapper.notesDTOtoNotes(notesDtoSaved);
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
