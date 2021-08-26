package hp.springprojs.hppetclinic.services.map;

import hp.springprojs.hppetclinic.model.Visit;
import hp.springprojs.hppetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
   
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){
            System.out.println(visit.getPet());
            System.out.println(visit.getPet().getOwner());
            System.out.println(visit.getPet().getId());
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
