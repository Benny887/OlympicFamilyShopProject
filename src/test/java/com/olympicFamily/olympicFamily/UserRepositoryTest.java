package com.olympicFamily.olympicFamily;

import com.olympicFamily.olympicFamily.BackEnd.User.UserRepository;
import com.olympicFamily.olympicFamily.Common.Entity.Role;
import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("starostar92@gmail.com", "1","Vit", "Sidorenko");
        user.addRole(roleAdmin);

        User savedUser = repo.save(user);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRole(){
        User user = new User("v824905@ya.ru", "1","Sid", "Vishes");
        Role roleEditor = new Role(3);
        Role roleAssistent = new Role(5);

        user.addRole(roleEditor);
        user.addRole(roleAssistent);

        User savedUser = repo.save(user);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(System.out::println);
    }

    @Test
    public void testGetUserById(){
       User userVit =  repo.findById(1).get();
        System.out.println(userVit);
       assertThat(userVit).isNotNull();
    }

    @Test
    public void testUpdateUserDetails(){
        User userVit =  repo.findById(1).get();
        userVit.setEnabled(true);
        userVit.setEmail("check99@gmail.com");
        repo.save(userVit);
    }

    @Test
    public void testUpdateUserRole(){
        User vit = repo.findById(2).get();

        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        vit.getRoles().remove(roleEditor);
        vit.addRole(roleSalesperson);

        repo.save(vit);
    }

    @Test
    public void testDeleteUser(){
        Integer userId =2;
        repo.deleteById(userId);
    }

    @Test
    public void testGetUserByEmail(){
        String email = "v824905@ya.ru";
        User user = repo.getUserByEmail(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void testCountById(){
        Integer id = 1;
        Long countById = repo.countById(id);

        assertThat(countById).isNotNull().isGreaterThan(0);
    }

    @Test
    public void testDisableUser(){
        Integer id = 1;
        repo.updateEnabledStatus(id, false);
    }

    @Test
    public void testEnableUser(){
        Integer id = 3;
        repo.updateEnabledStatus(id, true);
    }

}
