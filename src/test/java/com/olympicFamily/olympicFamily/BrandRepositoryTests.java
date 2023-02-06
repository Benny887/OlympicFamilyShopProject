package com.olympicFamily.olympicFamily;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.olympicFamily.olympicFamily.BackEnd.Admin.brand.BrandRepository;
import com.olympicFamily.olympicFamily.Common.Entity.Brand;
import com.olympicFamily.olympicFamily.Common.Entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BrandRepositoryTests {

    @Autowired
    private BrandRepository repo;

    @Test
    public void testCreateBrand1() {
        Category reebok = new Category(6);
        Brand acer = new Brand("Reebok");
        acer.getCategories().add(reebok);

        Brand savedBrand = repo.save(acer);

        assertThat(savedBrand).isNotNull();
        assertThat(savedBrand.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateBrand2() {
        Category tshirt = new Category(5);
        Category boots = new Category(7);

        Brand nike = new Brand("Nike");
        nike.getCategories().add(tshirt);
        nike.getCategories().add(boots);

        Brand savedBrand = repo.save(nike);

        assertThat(savedBrand).isNotNull();
        assertThat(savedBrand.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateBrand3() {
        Brand samsung = new Brand("Samsung");

        samsung.getCategories().add(new Category(29));	// category memory
        samsung.getCategories().add(new Category(24));	// category internal hard drive

        Brand savedBrand = repo.save(samsung);

        assertThat(savedBrand).isNotNull();
        assertThat(savedBrand.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAll() {
        Iterable<Brand> brands = repo.findAll();
        brands.forEach(System.out::println);

        assertThat(brands).isNotEmpty();
    }

    @Test
    public void testGetById() {
        Brand brand = repo.findById(1).get();

        assertThat(brand.getName()).isEqualTo("Acer");
    }

    @Test
    public void testUpdateName() {
        String newName = "Samsung Electronics";
        Brand samsung = repo.findById(3).get();
        samsung.setName(newName);

        Brand savedBrand = repo.save(samsung);
        assertThat(savedBrand.getName()).isEqualTo(newName);
    }

    @Test
    public void testDelete() {
        Integer id = 2;
        repo.deleteById(id);

        Optional<Brand> result = repo.findById(id);

        assertThat(result.isEmpty());
    }
}