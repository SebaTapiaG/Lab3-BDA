package proyecto.repositories;


import java.util.List;

import org.springframework.http.ResponseEntity;
import proyecto.models.CategoriaModel;

public interface CategoriaRepository {

    ResponseEntity <List<Object>> findAll();
    ResponseEntity<Object> findById(int id_categoria);

    ResponseEntity<Object> create(CategoriaModel categoria);

    ResponseEntity<Object> update(CategoriaModel categoria);

    ResponseEntity<Object> delete(int id_categoria);



}
