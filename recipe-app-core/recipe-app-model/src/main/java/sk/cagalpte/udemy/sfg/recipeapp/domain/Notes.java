package sk.cagalpte.udemy.sfg.recipeapp.domain;

import java.util.Objects;

public class Notes {
    private Long id;

    private String recipeNotes;

    private Recipe recipe;

    public Notes() {
    }

    public Notes(Long id, String recipeNotes, Recipe recipe) {
        this.id = id;
        this.recipeNotes = recipeNotes;
        this.recipe = recipe;
    }

    public Notes(NotesBuilder notesBuilder) {
        this.setId(notesBuilder.id);
        this.setRecipeNotes(notesBuilder.recipeNotes);
        this.setRecipe(notesBuilder.recipe);
    }

    public NotesBuilder createBuilder() {
        return new Notes.NotesBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Notes notes = (Notes) o;
        return Objects.equals(id, notes.id) &&
                Objects.equals(recipeNotes, notes.recipeNotes) &&
                Objects.equals(recipe, notes.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeNotes, recipe);
    }

    public static class NotesBuilder {
        private Long id;

        private String recipeNotes;

        private Recipe recipe;

        public NotesBuilder() {
        }

        public NotesBuilder id(Long id) {
            this.id = id;
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
