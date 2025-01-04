package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import proyecto.entities.AlmacenEntity;
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

import java.util.List;

@Service
public class AlmacenService {
    @Autowired
    AlmacenRepository almacenRepository;

    public ResponseEntity<List<Object>> findAll(){
        return almacenRepository.findAll();
    }
    public ResponseEntity<Object> findById(int id_almacen){
        return almacenRepository.findById(id_almacen);
    }

    public ResponseEntity<Object> create(AlmacenModel almacen){
        return almacenRepository.create(almacen);
    }

    public ResponseEntity<Object> update(AlmacenModel almacen){
        return almacenRepository.update(almacen);
    }

    public ResponseEntity<Object> delete(int id_almacen){
        return almacenRepository.delete(id_almacen);
    }


}
