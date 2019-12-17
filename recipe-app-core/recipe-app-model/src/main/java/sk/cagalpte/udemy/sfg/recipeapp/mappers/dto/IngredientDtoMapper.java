package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDto;

@Mapper
public interface IngredientDtoMapper {

    public final IngredientDtoMapper INSTANCE = Mappers.getMapper(IngredientDtoMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "recipe", target = "recipeDTO")
    public IngredientDto ingredientToIngredientDto(Ingredient ingredient);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "recipe", source = "recipeDTO")
    public Ingredient ingredientDtoToIngredient(IngredientDto ingredientDTO);
}
