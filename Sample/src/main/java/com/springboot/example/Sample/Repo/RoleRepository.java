package com.springboot.example.Sample.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.example.Sample.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
}