package sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.dto.UnitOfMeasureDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.UnitOfMeasureDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repository.UnitOfMeasureRepository;
import sk.cagalpte.udemy.sfg.recipeapp.repository.impl.hibernate.UnitOfMeasureRepositoryHibernate;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Repository
public class UnitOfMeasureRepositoryImpl implements UnitOfMeasureRepository {

    private final UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate;

    private final UnitOfMeasureDtoMapper unitOfMeasureDtoMapper;

    public UnitOfMeasureRepositoryImpl(UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate, UnitOfMeasureDtoMapper unitOfMeasureDtoMapper) {
        this.unitOfMeasureRepositoryHibernate = unitOfMeasureRepositoryHibernate;
        this.unitOfMeasureDtoMapper = unitOfMeasureDtoMapper;
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        List<UnitOfMeasure> unitOfMeasures = this.unitOfMeasureRepositoryHibernate.findAll().stream()
                .map(unitOfMeasureDTO -> {
                    return this.unitOfMeasureDtoMapper.unitOfMeasureDtoToUnitOfMeasure(unitOfMeasureDTO);
                }).collect(Collectors.toList());
        return unitOfMeasures;
    }

    @Override
    public UnitOfMeasure findById(Long id) {
        return this.unitOfMeasureDtoMapper.unitOfMeasureDtoToUnitOfMeasure(this.unitOfMeasureRepositoryHibernate.findById(id).orElse(null));
    }

    @Override
    public UnitOfMeasure findByUnitOfMeasureDescription(String unitOfMeasureDescription) {
        return this.unitOfMeasureDtoMapper.unitOfMeasureDtoToUnitOfMeasure(this.unitOfMeasureRepositoryHibernate.
                                                                        findByUnitOfMeasureDescription(unitOfMeasureDescription).orElse(null));
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        UnitOfMeasureDTO unitOfMeasureDTO = new UnitOfMeasureDTO().createBuilder()
                .unitOfMeasureDescription(unitOfMeasure.getUnitOfMeasureDescription())
                .build();
        UnitOfMeasureDTO unitOfMeasureDtoSaved = this.unitOfMeasureRepositoryHibernate.save(unitOfMeasureDTO);

        return this.unitOfMeasureDtoMapper.unitOfMeasureDtoToUnitOfMeasure(unitOfMeasureDtoSaved);
    }

    @Override
    public void delete(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasureRepositoryHibernate.delete(this.unitOfMeasureDtoMapper.unitOfMeasureToUnitOfMeasureDTO(unitOfMeasure));
    }

    @Override
    public void deleteById(Long id) {
        this.unitOfMeasureRepositoryHibernate.deleteById(id);
    }
}
