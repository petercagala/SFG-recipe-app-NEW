package sk.cagalpte.udemy.sfg.recipeapp.services.impl.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureRepService;

import java.util.List;

@Profile("jdbc")
@Service
public class UnitOfMeasureRepServiceImpl implements UnitOfMeasureRepService {
    @Override
    public List<UnitOfMeasure> findAll() {
        return null;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return null;
    }

    @Override
    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription) {
        return null;
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        return null;
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
