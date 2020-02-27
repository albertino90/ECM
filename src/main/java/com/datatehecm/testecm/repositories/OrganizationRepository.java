package com.datatehecm.testecm.repositories;

import com.datatehecm.testecm.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization getById(Long id);
}
