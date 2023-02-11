package com.olympicFamily.olympicFamily;

import static org.assertj.core.api.Assertions.assertThat;

import com.olympicFamily.olympicFamily.Common.Entity.Product;
import com.olympicFamily.olympicFamily.FrontEnd.product.FEProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FEProductRepositoryTests {

    @Autowired
    FEProductRepository repo;

    @Test
    public void testFindByAlias() {
        String alias = "Cap";
        Product product = repo.findByAlias(alias);

        assertThat(product).isNotNull();
    }

}
