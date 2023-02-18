package com.olympicFamily.olympicFamily.FrontEnd.setting;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Country;
import org.springframework.data.repository.CrudRepository;


public interface FECountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findAllByOrderByNameAsc();
}
