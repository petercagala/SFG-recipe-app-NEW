package sk.cagalpte.udemy.sfg.recipeapp.repository;

import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.repository.map.MapRepository;

@Repository
public interface UnitOfMeasureRepository extends MapRepository<UnitOfMeasure, Long> {
}
