package co.com.bancolombia.usecase.animals;

import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnimalsUseCase {
    private AnimalRepository animalRepository;
    public void create(Animal animal){
        try {
            animalRepository.create(animal);
        }catch (Exception e){
            System.out.println("Hola, mundo!");
        }

    }
    public Animal read(String id){return animalRepository.read(id);}
    public Animal update(String id, Animal animal)throws Exception{
        animalRepository.update(id,animal);
        return animal;
    }
    public void delete(String id){animalRepository.delete(id);}
    public List<Animal> getAll(){return animalRepository.getAll();}
}
