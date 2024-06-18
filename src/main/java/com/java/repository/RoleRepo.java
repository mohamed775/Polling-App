package com.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Role;
import com.java.entity.RoleName;


@Repository
public interface RoleRepo  extends JpaRepository<Role, Long>{

    Optional<Role> findByName(RoleName roleName);

}
