package com.olympicFamily.olympicFamily.BackEnd.User;

import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query("select u from User u where u.email = :email") //hql syntax
    User getUserByEmail(@Param("email") String email);

    Long countById(Integer id);

    @Query("select u from User u where concat(u.id, ' ', u.email, ' ', u.firstName, ' ', u.lastName) like %?1%")
    Page<User> findAll(String keyWord, Pageable pageable);

    @Query("update User u set u.enabled = ?2 where u.id = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);
}
