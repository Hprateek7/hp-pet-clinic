package hp.springprojs.hppetclinic.repositories;

import hp.springprojs.hppetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
