package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureRepService;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureService;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepService unitOfMeasureRepService;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepService unitOfMeasureRepService) {
        this.unitOfMeasureRepService = unitOfMeasureRepService;
    }

    @Override
    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription) {
        return this.unitOfMeasureRepService.findByUnitOfMeasureDescription(unitOfMeasureDescription);
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        return this.unitOfMeasureRepService.findAll();
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return this.unitOfMeasureRepService.findById(id);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        return this.unitOfMeasureRepService.save(unitOfMeasure);
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {
        this.delete(unitOfMeasure);
    }

    @Override
    public void deleteById(Long id) {
        this.unitOfMeasureRepService.deleteById(id);
    }
}
