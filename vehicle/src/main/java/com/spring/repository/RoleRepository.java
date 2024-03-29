package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Roles;

/**
 * Role Repository
 */
@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
