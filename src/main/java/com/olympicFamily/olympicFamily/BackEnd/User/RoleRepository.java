package com.olympicFamily.olympicFamily.BackEnd.User;

import com.olympicFamily.olympicFamily.Common.Entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
