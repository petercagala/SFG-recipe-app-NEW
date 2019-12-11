package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Notes;
import sk.cagalpte.udemy.sfg.recipeapp.dto.NotesDTO;

@Mapper
public interface NotesDtoMapper {

    public final NotesDtoMapper INSTANCE = Mappers.getMapper(NotesDtoMapper.class);

    @Mapping(source = "id", target = "id")
    public NotesDTO notesToNotesDto(Notes notes);

    @Mapping(source = "id", target = "id")
    public Notes notesDTOtoNotes(NotesDTO notesDTO);
}