package sk.cagalpte.udemy.sfg.recipeapp.services.impl;

import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.repository.UnitOfMeasureRepository;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureService;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription) {
        return this.unitOfMeasureRepository.findByUnitOfMeasureDescription(unitOfMeasureDescription);
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        return this.unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return this.unitOfMeasureRepository.findById(id);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        return this.unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {
        this.delete(unitOfMeasure);
    }

    @Override
    public void deleteById(Long id) {
        this.unitOfMeasureRepository.deleteById(id);
    }
}
