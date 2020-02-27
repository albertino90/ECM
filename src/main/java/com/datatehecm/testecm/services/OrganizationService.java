package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.Organization;

import java.util.List;

public interface OrganizationService {
    Organization getOrganization(Long id);
    List<Organization> findAll();
    Organization addOrganization (Organization organization);
    void delete(Long id);
    Organization update(Organization organization);
}
