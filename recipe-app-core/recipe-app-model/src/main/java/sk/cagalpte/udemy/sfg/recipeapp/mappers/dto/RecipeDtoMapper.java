package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDTO;

@Mapper
public interface RecipeDtoMapper {

    public final RecipeDtoMapper INSTANCE = Mappers.getMapper(RecipeDtoMapper.class);

    @Mapping(target = "id", source = "id")
    public RecipeDTO recipeToRecipeDTO(Recipe recipe);

    @Mapping(target = "id", source = "id")
    public Recipe recipeDtoToRecipe(RecipeDTO recipeDTO);
}
