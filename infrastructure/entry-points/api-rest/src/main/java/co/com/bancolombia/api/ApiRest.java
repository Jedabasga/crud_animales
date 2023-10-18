package co.com.bancolombia.api;
import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.usecase.animals.AnimalsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalsUseCase crudAnimalsUseCase;

    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }
    @GetMapping(path = "/consultanimal/{id}")
    public Animal read(@PathVariable String id){ return crudAnimalsUseCase.read(id);}
    @PostMapping(path ="/create")
    public void create(@RequestBody Animal animal){
        try {
            crudAnimalsUseCase.create(animal);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }

    }
    @PutMapping(path = "/update/{id}")
    public void update (@PathVariable String id,@RequestBody Animal animal){
        try {
            crudAnimalsUseCase.update(id,animal);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){crudAnimalsUseCase.delete(id);}
    @GetMapping(path = "/list")
    public List<Animal> getAll(){return crudAnimalsUseCase.getAll();}
}
