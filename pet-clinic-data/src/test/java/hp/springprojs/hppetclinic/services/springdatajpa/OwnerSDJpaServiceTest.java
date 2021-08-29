package hp.springprojs.hppetclinic.services.springdatajpa;

import hp.springprojs.hppetclinic.model.Owner;
import hp.springprojs.hppetclinic.repositories.OwnerRepository;
import hp.springprojs.hppetclinic.repositories.PetRepository;
import hp.springprojs.hppetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Smith");
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner = new Owner();
        owner.setId(2L);
        returnOwnersSet.add(owner);
        returnOwnersSet.add(this.owner);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        assertNotNull(service.findById(1L));
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(2L);
        when(ownerRepository.save(any())).thenReturn(owner);
        assertNotNull(service.save(owner));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner smith = service.findByLastName("Smith");
        assertEquals("Smith",smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}