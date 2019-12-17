package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Recipe;
import sk.cagalpte.udemy.sfg.recipeapp.dto.RecipeDto;

@Mapper
public interface RecipeDtoMapper {

    public final RecipeDtoMapper INSTANCE = Mappers.getMapper(RecipeDtoMapper.class);

    @Mapping(target = "id", source = "id")
    public RecipeDto recipeToRecipeDto(Recipe recipe);

    @Mapping(target = "id", source = "id")
    public Recipe recipeDtoToRecipe(RecipeDto recipeDTO);
}
