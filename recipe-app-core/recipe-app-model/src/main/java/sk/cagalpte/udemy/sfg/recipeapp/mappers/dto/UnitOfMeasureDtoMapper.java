package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.dto.UnitOfMeasureDTO;

@Mapper
public interface UnitOfMeasureDtoMapper {

    public final UnitOfMeasureDtoMapper INSTANCE = Mappers.getMapper(UnitOfMeasureDtoMapper.class);

    @Mapping(source = "id", target = "id")
    public UnitOfMeasureDTO unitOfMeasureToUnitOfMeasureDTO(UnitOfMeasure unitOfMeasure);

    @Mapping(target = "id", source = "id")
    public UnitOfMeasure unitOfMeasureDtoToUnitOfMeasure(UnitOfMeasureDTO unitOfMeasureDTO);


}
