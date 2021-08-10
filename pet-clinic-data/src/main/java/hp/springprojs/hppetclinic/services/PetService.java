package hp.springprojs.hppetclinic.services;

import hp.springprojs.hppetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
