package com.olympicFamily.olympicFamily.BackEnd.Admin.setting.state;

import com.olympicFamily.olympicFamily.Common.Entity.Country;
import com.olympicFamily.olympicFamily.Common.Entity.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Integer> {

    public List<State> findByCountryOrderByNameAsc(Country country);
}
