package sk.cagalpte.udemy.sfg.recipeapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "category")
@Data
@NoArgsConstructor
public class CategoryDto extends BasedEntityDto {

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    @JoinTable(name = "recipe__category",
            joinColumns = @JoinColumn(name = "CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_recipe__category_CATEGORY_ID")),
            inverseJoinColumns = @JoinColumn(name = "RECIPE_ID", foreignKey = @ForeignKey(name = "FK_recipe__category_RECIPE_ID")))
    private List<RecipeDto> recipeDTOS = new ArrayList<>();


    public CategoryDto(CategoryDtoBuilder categoryDtoBuilder) {
        super(categoryDtoBuilder);

        this.setDescription(categoryDtoBuilder.description);
        this.setRecipeDTOS(categoryDtoBuilder.recipeDTOS);
    }

    public CategoryDtoBuilder createBuilder() {
        return new CategoryDto.CategoryDtoBuilder();
    }



    public static class CategoryDtoBuilder extends BasedEntityDTOBuilder {

        private String description;

        private List<RecipeDto> recipeDTOS = new ArrayList<>();

        public CategoryDtoBuilder() {
        }

        @Override
        public CategoryDtoBuilder id(Long id) {
             super.id(id);
            return this;
        }

        public CategoryDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryDtoBuilder recipeDTOS(List<RecipeDto> recipeDTOS) {
            this.recipeDTOS = recipeDTOS;
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(this);
        }
    }
}
