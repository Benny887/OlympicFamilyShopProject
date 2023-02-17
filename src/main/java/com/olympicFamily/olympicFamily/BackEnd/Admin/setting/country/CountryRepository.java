package com.olympicFamily.olympicFamily.BackEnd.Admin.setting.country;

import com.olympicFamily.olympicFamily.Common.Entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    public List<Country> findAllByOrderByNameAsc();
}
