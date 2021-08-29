package hp.springprojs.hppetclinic.services.map;

import hp.springprojs.hppetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetServiceMap());
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Smith");
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        assertEquals(1L,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Owner owner2 = new Owner();
        owner2.setId(2l);
        assertEquals(owner2,ownerMapService.save(owner2));
    }

    @Test
    void findById() {
        assertEquals(1L,ownerMapService.findById(1L).getId());
    }

    @Test
    void findByLastName() {
        assertEquals(1L,ownerMapService.findByLastName("Smith").getId());
    }
}