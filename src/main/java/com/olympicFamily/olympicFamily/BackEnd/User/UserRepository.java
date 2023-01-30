package com.olympicFamily.olympicFamily.BackEnd.User;

import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.email = :email") //hql syntax
    public User getUserByEmail(@Param("email") String email);

    public Long countById(Integer id);
}
