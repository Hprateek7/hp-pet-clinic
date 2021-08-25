package hp.springprojs.hppetclinic.repositories;

import hp.springprojs.hppetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
