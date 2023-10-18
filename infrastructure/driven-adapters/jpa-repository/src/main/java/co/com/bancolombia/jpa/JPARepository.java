package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.AnimalsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<AnimalsEntity/* change for adapter model */, String>
        , QueryByExampleExecutor<AnimalsEntity/* change for adapter model */> {}
