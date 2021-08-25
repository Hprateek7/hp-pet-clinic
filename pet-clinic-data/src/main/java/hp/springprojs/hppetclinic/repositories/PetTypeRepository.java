package hp.springprojs.hppetclinic.repositories;

import hp.springprojs.hppetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
