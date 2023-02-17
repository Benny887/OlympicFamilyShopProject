package com.olympicFamily.olympicFamily.BackEnd.Admin.setting;

import com.olympicFamily.olympicFamily.Common.Entity.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    public List<Currency> findAllByOrderByNameAsc();
}
