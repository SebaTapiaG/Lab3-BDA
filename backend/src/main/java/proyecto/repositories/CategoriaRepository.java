package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import proyecto.models.CategoriaModel;

public interface CategoriaRepository extends MongoRepository<CategoriaModel, ObjectId> {

    List<CategoriaModel> findAll();

    Optional<CategoriaModel> findById(ObjectId id_categoria);
    
    ResponseEntity<Object> create(CategoriaModel categoria);

    ResponseEntity<Object> update(CategoriaModel categoria);
    ResponseEntity<Object> save(CategoriaModel categoria);
    ResponseEntity<Object> delete(ObjectId id_categoria);



}
