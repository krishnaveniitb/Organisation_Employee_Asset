package com.Siemens.Service;

import com.Siemens.Model.Asset;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;

import java.util.List;

public interface OrganizationService {
    public Organization add(Organization organization);

    public List<Organization> getAllOrganisationList();

    public Organization getOrganisationById(Long id);

    Organization updateOrganisation(Organization organization);

    String deleteOrganization(Long org_id);
}
