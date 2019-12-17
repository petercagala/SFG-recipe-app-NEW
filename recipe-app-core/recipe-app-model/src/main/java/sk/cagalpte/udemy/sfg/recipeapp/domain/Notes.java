package sk.cagalpte.udemy.sfg.recipeapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Notes extends BaseEntity {

    private String recipeNotes;

    private Recipe recipe;

    public Notes(NotesBuilder notesBuilder) {
        super(notesBuilder);

        this.setRecipeNotes(notesBuilder.recipeNotes);
        this.setRecipe(notesBuilder.recipe);
    }

    public NotesBuilder createBuilder() {
        return new Notes.NotesBuilder();
    }



    public static class NotesBuilder extends BaseEntityBuilder {

        protected String recipeNotes;

        protected Recipe recipe;

        public NotesBuilder() {
        }

        @Override
        public NotesBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public NotesBuilder recipeNotes(String recipeNotes) {
            this.recipeNotes = recipeNotes;
            return this;
        }

        public NotesBuilder recipe(Recipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public Notes build() {
            return new Notes(this);
        }
    }
}
