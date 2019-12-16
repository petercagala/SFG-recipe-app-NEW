package sk.cagalpte.udemy.sfg.recipeapp.services;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.services.map.MapRepository;

@Service
public interface UnitOfMeasureRepService extends MapRepository<UnitOfMeasure, Long> {

    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription);
}
