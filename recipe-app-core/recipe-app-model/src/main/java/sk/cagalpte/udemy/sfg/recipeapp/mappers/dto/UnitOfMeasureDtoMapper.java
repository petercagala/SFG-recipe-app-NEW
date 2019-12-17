package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.dto.UnitOfMeasureDto;

@Mapper
public interface UnitOfMeasureDtoMapper {

    public final UnitOfMeasureDtoMapper INSTANCE = Mappers.getMapper(UnitOfMeasureDtoMapper.class);

    @Mapping(source = "id", target = "id")
    public UnitOfMeasureDto unitOfMeasureToUnitOfMeasureDto(UnitOfMeasure unitOfMeasure);

    @Mapping(target = "id", source = "id")
    public UnitOfMeasure unitOfMeasureDtoToUnitOfMeasure(UnitOfMeasureDto unitOfMeasureDTO);


}
