
package school.service;

import java.util.List;
import school.entity.Trainer;


public interface TrainerServiceInterface {
    List<Trainer> findAll();
     Trainer findById(int id);
     void delete(int id);
     Trainer save(Trainer trainer);
     List<String> getSubjects();
}
