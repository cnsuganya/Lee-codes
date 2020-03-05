package com.example.demo.repository;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRoleName(String rolename);
}