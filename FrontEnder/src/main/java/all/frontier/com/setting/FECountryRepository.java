package all.frontier.com.setting;

import all.common.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FECountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findAllByOrderByNameAsc();
}
