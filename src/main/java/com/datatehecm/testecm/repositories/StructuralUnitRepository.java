package com.datatehecm.testecm.repositories;

import com.datatehecm.testecm.model.StructuralUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructuralUnitRepository extends JpaRepository<StructuralUnit, Long> {

}
