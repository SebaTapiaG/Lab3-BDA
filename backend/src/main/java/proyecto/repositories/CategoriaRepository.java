package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

import org.springframework.http.ResponseEntity;
import proyecto.models.CategoriaModel;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, ObjectId> {

    ResponseEntity <List<Object>> findAll();

    ResponseEntity<Object> findById(int id_categoria);

<<<<<<< Updated upstream
    ResponseEntity<Object> create(CategoriaModel categoria);

    ResponseEntity<Object> update(CategoriaModel categoria);
=======
    ResponseEntity<Object> save(CategoriaEntity categoria);
>>>>>>> Stashed changes

    ResponseEntity<Object> delete(int id_categoria);



}
