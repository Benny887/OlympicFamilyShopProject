package all.frontier.com.setting;

import all.common.entity.Country;
import all.common.entity.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FEStateRepository extends CrudRepository<State, Integer> {

    List<State> findByCountryOrderByNameAsc(Country country);
}
