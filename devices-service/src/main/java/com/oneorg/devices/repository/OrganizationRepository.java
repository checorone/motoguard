package com.oneorg.devices.repository;

import com.oneorg.devices.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String>  {
    public Organization findById(String organizationId);
}
