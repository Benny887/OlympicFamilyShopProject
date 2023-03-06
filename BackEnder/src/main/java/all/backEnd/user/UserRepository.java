package all.backEnd.user;

import all.backEnd.admin.paging.SearchRepository;
import all.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends SearchRepository<User, Integer> {

    @Query("select u from User u where u.email = :email") //hql syntax
    User getUserByEmail(@Param("email") String email);

    Long countById(Integer id);

    @Query("select u from User u where concat(u.id, ' ', u.email, ' ', u.firstName, ' ', u.lastName) like %?1%")
    Page<User> findAll(String keyword, Pageable pageable);

    @Query("update User u set u.enabled = ?2 where u.id = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);
}
