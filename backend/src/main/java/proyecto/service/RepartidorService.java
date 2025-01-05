package proyecto.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.models.RepartidorModel;
import proyecto.repositories.RepartidorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepartidorService {
    @Autowired
    RepartidorRepository repartidorRepository;

    public List<RepartidorModel> findAll() {
        return repartidorRepository.findAll();
    }

    public Optional<RepartidorModel> findById(ObjectId id) {
        return repartidorRepository.findById(id);
    }

    public ResponseEntity<Object> findByNombre(String nombre) {
        return repartidorRepository.findByNombre(nombre);
    }

    public ResponseEntity<Object> findByEmail(String email) {
        return repartidorRepository.findByEmail(email);
    }

    public ResponseEntity<List<RepartidorModel>> findByAlmacen(int idAlmacen){
        return repartidorRepository.findByAlmacen(idAlmacen);
    }

    public ResponseEntity<Object> update(RepartidorModel repartidor){
        return repartidorRepository.update(repartidor);
    }

    public ResponseEntity<Object> delete(int id) {
        return repartidorRepository.delete(id);
    }

    public ResponseEntity<Object> register(RepartidorModel repartidor){
        return repartidorRepository.register(repartidor);
    }

    public ResponseEntity<Object> login(RepartidorModel repartidor){
        return repartidorRepository.login(repartidor.getEmail(), repartidor.getContrasena());
    }

}
