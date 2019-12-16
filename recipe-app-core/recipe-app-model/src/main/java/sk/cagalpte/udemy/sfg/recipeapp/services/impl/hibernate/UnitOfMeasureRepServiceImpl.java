package sk.cagalpte.udemy.sfg.recipeapp.services.impl.hibernate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.cagalpte.udemy.sfg.recipeapp.domain.UnitOfMeasure;
import sk.cagalpte.udemy.sfg.recipeapp.dto.UnitOfMeasureDTO;
import sk.cagalpte.udemy.sfg.recipeapp.mappers.dto.UnitOfMeasureDtoMapper;
import sk.cagalpte.udemy.sfg.recipeapp.repositories.UnitOfMeasureRepositoryHibernate;
import sk.cagalpte.udemy.sfg.recipeapp.services.UnitOfMeasureRepService;

import java.util.List;
import java.util.stream.Collectors;

@Profile("hibernate")
@Service
public class UnitOfMeasureRepServiceImpl implements UnitOfMeasureRepService {

    private final UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate;

    private final UnitOfMeasureDtoMapper unitOfMeasureDtoMapper;

    public UnitOfMeasureRepServiceImpl(UnitOfMeasureRepositoryHibernate unitOfMeasureRepositoryHibernate, UnitOfMeasureDtoMapper unitOfMeasureDtoMapper) {
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
