package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Ingredient;
import sk.cagalpte.udemy.sfg.recipeapp.dto.IngredientDTO;

@Mapper
public interface IngredientDtoMapper {

    public final IngredientDtoMapper INSTANCE = Mappers.getMapper(IngredientDtoMapper.class);

    @Mapping(source = "id", target = "id")
    public IngredientDTO ingredintToIngredientDTO(Ingredient ingredient);

    @Mapping(target = "id", source = "id")
    public IngredientDTO ingredientDtoToIngredient(IngredientDTO ingredientDTO);
}
