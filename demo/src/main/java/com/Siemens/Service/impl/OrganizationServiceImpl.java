package com.Siemens.Service.impl;

import com.Siemens.Exception.NoValueFoundException;
import com.Siemens.Model.Employee;
import com.Siemens.Model.Organization;
import com.Siemens.Repo.AssetRepo;
import com.Siemens.Repo.EmployeeRepo;
import com.Siemens.Repo.OrganizationRepo;
import com.Siemens.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Organization add(Organization organization) {
        List<Employee> employeeList = organization.getEmployeeList();
        if(employeeList!=null){
            employeeRepo.saveAll(employeeList);
        }
        if(organization.getAssetList()!=null) {
            assetRepo.saveAll(organization.getAssetList());
        }
        return organizationRepo.save(organization);
    }

    @Override
    public List<Organization> getAllOrganisationList() {
        List<Organization> organizationList = new ArrayList<>();
        organizationRepo.findAll().forEach(organizationList::add);
        return organizationList;
    }
    @Override
    public Organization getOrganisationById(Long id) {
        Optional<Organization> organization = organizationRepo.findById(id);
        if(organization.isPresent()){
            return organization.get();
        }
        else {
            throw new NoValueFoundException("No Organization found for this id! Try again with some other Id");
        }
    }

    @Override
    public Organization updateOrganisation(Organization organization) {
        return organizationRepo.save(organization);
    }

    @Override
    public String deleteOrganization(Long org_id) {
        organizationRepo.deleteById(org_id);
        return "Deleted successfully";
    }

}
