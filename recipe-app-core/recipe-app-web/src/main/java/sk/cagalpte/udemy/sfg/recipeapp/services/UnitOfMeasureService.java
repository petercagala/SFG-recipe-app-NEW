package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapService;

@Service
public interface UnitOfMeasureService extends MapService<UnitOfMeasure, Long> {
    UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription);
}
