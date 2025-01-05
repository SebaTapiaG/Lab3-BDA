package proyecto.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import proyecto.models.RepartidorModel;

import java.util.List;
import java.util.Optional;

public interface RepartidorRepository extends MongoRepository<RepartidorModel, ObjectId> {
    ResponseEntity<Object> findByNombre(String name);
    ResponseEntity<Object> findByEmail(String email);
    Optional<RepartidorModel> findById(ObjectId id_repartidor);
    List<RepartidorModel> findAll();
    ResponseEntity<Object> update(RepartidorModel repartidor);
    ResponseEntity<Object> delete(ObjectId idRepartidor);
    ResponseEntity<Object> register(RepartidorModel repartidor);
    ResponseEntity<Object> login(String email, String password);
}
