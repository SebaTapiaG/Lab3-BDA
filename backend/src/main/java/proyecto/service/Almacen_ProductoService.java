package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
=======
import proyecto.entities.Almacen_ProductoEntity;
>>>>>>> Stashed changes

import java.util.List;

@Service
public class Almacen_ProductoService {
    @Autowired
    Almacen_ProductoRepository almacen_productoRepository;

    public ResponseEntity<List<Object>> findAll(){
        return almacen_productoRepository.findAll();
    }

    public ResponseEntity<Object> findById(int id_almacen_producto){
        return almacen_productoRepository.findById(id_almacen_producto);
    }

    public ResponseEntity<Object> create(Almacen_ProductoModel almacen_producto){
        return almacen_productoRepository.create(almacen_producto);
    }

    public ResponseEntity<Object> update(Almacen_ProductoModel almacen_producto){
        return almacen_productoRepository.update(almacen_producto);
    }

    public ResponseEntity<Object> delete(int id_almacen_producto){
        return almacen_productoRepository.delete(id_almacen_producto);
    }
}
