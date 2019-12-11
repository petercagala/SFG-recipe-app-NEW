package sk.cagalpte.udemy.sfg.recipeapp.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "category")
public class CategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    @JoinTable(name = "recipe__category",
            joinColumns = @JoinColumn(name = "CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_recipe__category_CATEGORY_ID")),
            inverseJoinColumns = @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_recipe__category_RECIPE_ID")))
    private List<RecipeDTO> recipeDTOS = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(CategoryDtoBuilder categoryDtoBuilder) {
        this.setId(categoryDtoBuilder.id);
        this.setDescription(categoryDtoBuilder.description);
        this.setRecipeDTOS(categoryDtoBuilder.recipeDTOS);
    }

    public CategoryDtoBuilder createBuilder() {
        return new CategoryDTO.CategoryDtoBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeDTO> getRecipeDTOS() {
        return recipeDTOS;
    }

    public void setRecipeDTOS(List<RecipeDTO> recipeDTOS) {
        this.recipeDTOS = recipeDTOS;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(recipeDTOS, that.recipeDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, recipeDTOS);
    }

    public static class CategoryDtoBuilder {
        private Long id;

        private String description;

        private List<RecipeDTO> recipeDTOS = new ArrayList<>();

        public CategoryDtoBuilder() {
        }

        public CategoryDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryDtoBuilder recipeDTOS(List<RecipeDTO> recipeDTOS) {
            this.recipeDTOS = recipeDTOS;
            return this;
        }

        public CategoryDTO build() {
            return new CategoryDTO(this);
        }
    }
}
