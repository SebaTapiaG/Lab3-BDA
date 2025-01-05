package proyecto.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.models.CategoriaModel;
import proyecto.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll(){
        return categoriaRepository.findAll();
    }
    public Optional<CategoriaModel> findById(ObjectId id_categoria){
        return categoriaRepository.findById(id_categoria);
    }

    public ResponseEntity<Object> create(CategoriaModel categoria){
        return categoriaRepository.create(categoria);
    }

    public ResponseEntity<Object> update(CategoriaModel categoria){
        return categoriaRepository.update(categoria);
    }

    public ResponseEntity<Object> delete(ObjectId id_categoria){
        return categoriaRepository.delete(id_categoria);
    }

}
