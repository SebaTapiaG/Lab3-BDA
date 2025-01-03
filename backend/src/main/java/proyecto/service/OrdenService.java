package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.dto.RepartidorDTO;
import proyecto.entities.OrdenEntity;
import proyecto.repositories.OrdenRepository;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public ResponseEntity<List<OrdenEntity>> findAll() {
        List<OrdenEntity> ordenes = ordenRepository.findAll();
        if (ordenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ordenes);
    }

    public ResponseEntity<OrdenEntity> findById(String id_orden) {
        return ordenRepository.findById(id_orden)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<OrdenEntity> create(OrdenEntity orden) {
        OrdenEntity createdOrder = ordenRepository.save(orden);
        return ResponseEntity.ok(createdOrder);
    }

    public ResponseEntity<OrdenEntity> update(OrdenEntity orden) {
        // Si la orden existe, se actualiza. Si no, puedes lanzar un error.
        if (ordenRepository.existsById(orden.getId())) {
            OrdenEntity updatedOrder = ordenRepository.save(orden);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> delete(String id_orden) {
        if (ordenRepository.existsById(id_orden)) {
            ordenRepository.deleteById(id_orden);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/*
    public ResponseEntity<List<RepartidorDTO>> findDeliveryCompletedInArea(int id_zona) {
        // Realizar consulta en MongoDB o con MongoTemplate si es necesario
        List<RepartidorDTO> result = ordenRepository.findDeliveryCompletedInArea(id_zona);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }
    */

}
