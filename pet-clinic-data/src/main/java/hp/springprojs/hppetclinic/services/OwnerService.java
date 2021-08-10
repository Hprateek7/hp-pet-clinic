package hp.springprojs.hppetclinic.services;

import hp.springprojs.hppetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}