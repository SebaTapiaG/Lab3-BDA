package proyecto.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import proyecto.models.ZonaModel;

import java.util.List;

public interface ZonaRepository extends MongoRepository<ZonaModel, ObjectId> {
    List<ZonaModel> findAll();
    ResponseEntity<Object> findById(int id_zona);
    ResponseEntity<List<Object>> findByEstado(String estado);
    ResponseEntity<Object> create(ZonaModel zona);
    ResponseEntity<Object> update(ZonaModel zona);
    ResponseEntity<Object> delete(int id_zona);
}
