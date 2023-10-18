package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public void create (Animal animal)throws Exception{
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        String genero = animal.getGenero().toUpperCase();
        if (!genero.equals("M") && !genero.equals("H")) {
            throw new Exception("El campo 'genero' debe ser 'M' o 'H' " +genero);
        }
        animal.setGenero(genero);
        jpaRepositoryAdapter.save(animal);
    }
    @Override
    public Animal read(String id){return jpaRepositoryAdapter.findById(id);}
    @Override
    public Animal update(String id, Animal animal)throws Exception{
        Animal animaldb = jpaRepositoryAdapter.findById(id);
        if (animaldb == null )throw new Exception("Animal No encontrado : "+id);
        animaldb.setEspecie(animal.getEspecie());
        animaldb.setNumpatas(animal.getNumpatas());
        animaldb.setGenero(animal.getGenero().toUpperCase());
        animaldb.setHabitad(animal.getHabitad());
        animaldb.setDomestico(animal.isDomestico());
        jpaRepositoryAdapter.save(animaldb);
        return animaldb;
    }
    @Override
    public void delete(String id){jpaRepositoryAdapter.deleteById(id);}
    @Override
    public List<Animal> getAll(){return jpaRepositoryAdapter.findAll();}

}
