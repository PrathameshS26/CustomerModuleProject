package com.cg.fleetmanagement.customermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fleetmanagement.customermodule.model.PostalFeed;

@Repository
public interface PostalFeedRepository extends JpaRepository<PostalFeed, Integer> {

}
