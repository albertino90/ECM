package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.StructuralUnit;

import java.util.List;

public interface StructuralUnitService {
    StructuralUnit getStructuralUnit(Long id);
    List<StructuralUnit> findAll();
    StructuralUnit addStructuralUnit (StructuralUnit structuralUnit);
    void delete(Long id);
    StructuralUnit update(StructuralUnit structuralUnit);
}
