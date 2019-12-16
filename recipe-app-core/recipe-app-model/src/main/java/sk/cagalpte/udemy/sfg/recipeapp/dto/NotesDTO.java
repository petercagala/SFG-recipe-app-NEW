package sk.cagalpte.udemy.sfg.recipeapp.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "notes")
public class NotesDTO extends BasedEntityDTO {

    @Column(name = "RECIPE_NOTES")
    @Lob
//    @Lob saves the data in BLOB or CLOB. Let�s understand what is BLOB and CLOB
//
//    CLOB(Character Large Object): If data is text and is not enough to save in VARCHAR, then that data should be saved in CLOB.
//
//            BLOB(Binary Large Object): In case of double byte character large data is saved in BLOB data type.
    private String recipeNotes;

    @OneToOne
    @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_notes_RECIPE_ID"))
    private RecipeDTO recipeDTO;

    public NotesDTO() {
    }

    public NotesDTO(NotesDTOBuilder notesDTOBuilder) {
        super(notesDTOBuilder);

        this.setRecipeNotes(notesDTOBuilder.recipeNotes);
        this.setRecipeDTO(notesDTOBuilder.recipeDTO);
    }

    public NotesDTOBuilder createBuilder() {
        return new NotesDTO.NotesDTOBuilder();
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public RecipeDTO getRecipeDTO() {
        return recipeDTO;
    }

    public void setRecipeDTO(RecipeDTO recipeDTO) {
        this.recipeDTO = recipeDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NotesDTO notesDTO = (NotesDTO) o;
        return Objects.equals(recipeNotes, notesDTO.recipeNotes) &&
                Objects.equals(recipeDTO, notesDTO.recipeDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipeNotes, recipeDTO);
    }

    public static class NotesDTOBuilder extends BasedEntityDTOBuilder {

        protected String recipeNotes;

        protected RecipeDTO recipeDTO;

        public NotesDTOBuilder() {
        }

        @Override
        public NotesDTOBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public NotesDTOBuilder recipeNotes(String recipeNotes) {
            this.recipeNotes = recipeNotes;
            return this;
        }

        public NotesDTOBuilder recipeDTO(RecipeDTO recipeDTO) {
            this.recipeDTO = recipeDTO;
            return this;
        }

        public NotesDTO build() {
            return new NotesDTO(this);
        }
    }
}
