package com.Siemens.Repo;

import com.Siemens.Model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends CrudRepository<Organization,Long> {
}
