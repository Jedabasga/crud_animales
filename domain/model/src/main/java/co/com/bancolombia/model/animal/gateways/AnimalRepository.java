package co.com.bancolombia.model.animal.gateways;

import co.com.bancolombia.model.animal.Animal;

import java.util.List;

public interface AnimalRepository {
    void create(Animal animal) throws Exception;
    Animal read(String id);
    default Animal update(String id, Animal animal) throws Exception{
        return animal;
    }
    void delete(String id);
    List<Animal>getAll();
}
