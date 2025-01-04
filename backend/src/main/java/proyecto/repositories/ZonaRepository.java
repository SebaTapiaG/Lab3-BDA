package proyecto.repositories;

import org.springframework.http.ResponseEntity;
import proyecto.models.ZonaModel;

import java.util.List;

public interface ZonaRepository {
    ResponseEntity<List<Object>> findAll();
    ResponseEntity<Object> findById(int id_zona);
    ResponseEntity<List<Object>> findByEstado(String estado);
    ResponseEntity<Object> create(ZonaModel zona);
    ResponseEntity<Object> update(ZonaModel zona);
    ResponseEntity<Object> delete(int id_zona);
}
