package sk.cagalpte.udemy.sfg.recipeapp.domain;

import java.util.Objects;

public class Notes extends BaseEntity {

    private String recipeNotes;

    private Recipe recipe;

    public Notes() {
    }

    public Notes(NotesBuilder notesBuilder) {
        super(notesBuilder);

        this.setRecipeNotes(notesBuilder.recipeNotes);
        this.setRecipe(notesBuilder.recipe);
    }

    public NotesBuilder createBuilder() {
        return new Notes.NotesBuilder();
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Notes notes = (Notes) o;
        return Objects.equals(recipeNotes, notes.recipeNotes) &&
                Objects.equals(recipe, notes.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipeNotes, recipe);
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
