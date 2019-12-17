package sk.cagalpte.udemy.sfg.recipeapp.mappers.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.cagalpte.udemy.sfg.recipeapp.domain.Category;
import sk.cagalpte.udemy.sfg.recipeapp.dto.CategoryDto;

@Mapper
public interface CategoryDtoMapper {

    public final CategoryDtoMapper INSTANCE = Mappers.getMapper(CategoryDtoMapper.class);

    @Mapping(source = "id", target = "id")
    public CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "id", source = "id")
    public Category categoryDtoToCategory(CategoryDto categoryDTO);

//    Set<OrderDto> ordersToOrderDtos(Stream<Order> orders);
//
//    OrderDto orderToOrderDto(Order order);
}
