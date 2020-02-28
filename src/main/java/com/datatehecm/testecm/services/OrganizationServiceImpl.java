package com.datatehecm.testecm.services;

import com.datatehecm.testecm.model.Organization;
import com.datatehecm.testecm.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganization(Long id) {
        return organizationRepository.getById(id);
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization addOrganization(Organization organization) {
        return organizationRepository.saveAndFlush(organization);
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public Organization update(Organization organization) {
        return organizationRepository.saveAndFlush(organization);
    }
}
