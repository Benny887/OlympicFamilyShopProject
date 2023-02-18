package com.olympicFamily.olympicFamily.FrontEnd.setting;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Country;
import com.olympicFamily.olympicFamily.Common.Entity.State;
import org.springframework.data.repository.CrudRepository;

public interface FEStateRepository extends CrudRepository<State, Integer> {

    List<State> findByCountryOrderByNameAsc(Country country);
}
