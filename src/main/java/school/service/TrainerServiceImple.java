package school.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.entity.Trainer;
import school.repository.TrainerRepoImple;

@Transactional
@Service
public class TrainerServiceImple implements TrainerServiceInterface {

    @Autowired
    private TrainerRepoImple trainerRepoImple;

    @Override
    public List<Trainer> findAll() {
        return trainerRepoImple.findAll();
    }

    @Override
    public Trainer findById(int id) {
        return trainerRepoImple.findById(id);
    }

    @Override
    public void delete(int id) {
        trainerRepoImple.delete(id);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return trainerRepoImple.save(trainer);
    }

    @Override
    public List<String> getSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("C#");
        subjects.add("Javascript");
        subjects.add("Python");
        return subjects;
    }
}
