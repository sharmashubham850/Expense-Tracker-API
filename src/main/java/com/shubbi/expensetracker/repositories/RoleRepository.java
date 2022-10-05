package com.shubbi.expensetracker.repositories;

import com.shubbi.expensetracker.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
