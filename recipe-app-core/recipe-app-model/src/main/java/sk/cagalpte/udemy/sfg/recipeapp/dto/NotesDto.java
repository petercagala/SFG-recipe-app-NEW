package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "notes")
@Data
@NoArgsConstructor
public class NotesDto extends BasedEntityDto {

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
    private RecipeDto recipeDTO;


    public NotesDto(NotesDTOBuilder notesDTOBuilder) {
        super(notesDTOBuilder);

        this.setRecipeNotes(notesDTOBuilder.recipeNotes);
        this.setRecipeDTO(notesDTOBuilder.recipeDTO);
    }

    public NotesDTOBuilder createBuilder() {
        return new NotesDto.NotesDTOBuilder();
    }

    public static class NotesDTOBuilder extends BasedEntityDTOBuilder {

        protected String recipeNotes;

        protected RecipeDto recipeDTO;

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

        public NotesDTOBuilder recipeDTO(RecipeDto recipeDTO) {
            this.recipeDTO = recipeDTO;
            return this;
        }

        public NotesDto build() {
            return new NotesDto(this);
        }
    }
}
