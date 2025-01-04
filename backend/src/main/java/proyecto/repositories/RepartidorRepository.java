package proyecto.repositories;
import org.springframework.http.ResponseEntity;
import proyecto.models.RepartidorModel;

import java.util.List;

public interface RepartidorRepository {
    public ResponseEntity<Object> findByNombre(String name);
    public ResponseEntity<Object> findByEmail(String email);
    public ResponseEntity<Object> findById(int id_repartidor);
    public ResponseEntity<List<Object>> findAll();
    public ResponseEntity<List<RepartidorModel>>  findByAlmacen(int idAlmacen);
    public ResponseEntity<Object> update(RepartidorModel repartidor);
    public ResponseEntity<Object> delete(int idRepartidor);
    public ResponseEntity<Object> register(RepartidorModel repartidor);
    public ResponseEntity<Object> login(String email, String password);
}
