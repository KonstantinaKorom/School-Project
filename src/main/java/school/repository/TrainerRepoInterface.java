package school.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import school.entity.Trainer;

/**
 *
 * @author Koko
 */
public interface TrainerRepoInterface {

    List<Trainer> findAll();

    Trainer findById(int id);
    void delete(int id);
    Trainer save(Trainer trainer);
    
}
