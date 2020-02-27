package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.StructuralUnit;
import com.datatehecm.testecm.repositories.StructuralUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StructuralUnitServiceImpl implements StructuralUnitService {

    StructuralUnitRepository structuralUnitRepository;

    @Override
    public StructuralUnit getStructuralUnit(Long id) {
        return structuralUnitRepository.getById(id);
    }

    @Override
    public List<StructuralUnit> findAll() {
        return structuralUnitRepository.findAll();
    }

    @Override
    public StructuralUnit addStructuralUnit(StructuralUnit structuralUnit) {
        return structuralUnitRepository.saveAndFlush(structuralUnit);
    }

    @Override
    public void delete(Long id) {
        structuralUnitRepository.deleteById(id);
    }

    @Override
    public StructuralUnit update(StructuralUnit structuralUnit) {
        return structuralUnitRepository.saveAndFlush(structuralUnit);
    }
}
