package proyecto.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.models.OrdenModel;
import proyecto.repositories.OrdenRepository;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public ResponseEntity<List<OrdenModel>> findAll() {
        List<OrdenModel> ordenes = ordenRepository.findAll();
        if (ordenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordenes);
    }

    public ResponseEntity<OrdenModel> findById(ObjectId id_orden) {
        return ordenRepository.findById(id_orden)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<OrdenModel> create(OrdenModel orden) {
        OrdenModel createdOrder = ordenRepository.save(orden);
        return ResponseEntity.ok(createdOrder);
    }

    public ResponseEntity<OrdenModel> update(OrdenModel orden) {
        // Si la orden existe, se actualiza. Si no, puedes lanzar un error.
        if (ordenRepository.existsById(orden.getId())) {
            OrdenModel updatedOrder = ordenRepository.save(orden);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> delete(ObjectId id_orden) {
        if (ordenRepository.existsById(id_orden)) {
            ordenRepository.deleteById(id_orden);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<OrdenModel> findByEmailCliente(String email) {
        return ordenRepository.findByEmailCliente(email);
    }
/*
    public ResponseEntity<List<RepartidorDTO>> findDeliveryCompletedInArea(int id_zona) {
        // Realizar consulta en MongoDB o con MongoTemplate si es necesario
        List<RepartidorDTO> result = ordenRepository.findDeliveryCompletedInArea(id_zona);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }
    */

}
