package hp.springprojs.hppetclinic.repositories;

import hp.springprojs.hppetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
