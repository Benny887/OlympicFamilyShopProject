package all.backEnd.admin.setting;

import all.common.entity.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    public List<Currency> findAllByOrderByNameAsc();
}
