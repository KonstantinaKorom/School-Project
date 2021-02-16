
package school.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import school.entity.Trainer;


@Repository
public class TrainerRepoImple extends HibernateUtil<Trainer> implements TrainerRepoInterface {

    @Override
    public List<Trainer> findAll() {
        return super.findAll("Trainer.findAll");
 }

    @Override
    public Trainer findById(int id) {
        return super.findById("Trainer.findById", id);
    }

    @Override
    public void delete(int id) {
       super.delete(Trainer.class, id);
    }

    @Override
    public Trainer save(Trainer trainer) {
    return super.save(trainer);
    }

}
