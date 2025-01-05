package proyecto.repositories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import proyecto.models.RepartidorModel;

import java.util.List;

public interface RepartidorRepository extends MongoRepository<RepartidorModel, ObjectId> {
    ResponseEntity<Object> findByNombre(String name);
    ResponseEntity<Object> findByEmail(String email);
    ResponseEntity<Object> findById(int id_repartidor);
    List<RepartidorModel> findAll();
    ResponseEntity<List<RepartidorModel>>  findByAlmacen(int idAlmacen);
    ResponseEntity<Object> update(RepartidorModel repartidor);
    ResponseEntity<Object> delete(int idRepartidor);
    ResponseEntity<Object> register(RepartidorModel repartidor);
    ResponseEntity<Object> login(String email, String password);
}
