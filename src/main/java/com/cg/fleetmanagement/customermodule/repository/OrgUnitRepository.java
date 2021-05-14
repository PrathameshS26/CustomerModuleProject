package com.cg.fleetmanagement.customermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fleetmanagement.customermodule.model.OrgUnit;

@Repository
public interface OrgUnitRepository extends JpaRepository<OrgUnit, Integer> {

}
