package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import proyecto.models.Detalle_OrdenEntity;

import java.util.List;

@Service
public class Detalle_OrdenService {

    @Qualifier("detalle_OrdenRepository")
    @Autowired
    private Detalle_OrdenRepository detalle_ordenRepository;

    // Obtener todos los detalles de orden
    public List<Detalle_OrdenModel> findAll() {
        return detalle_ordenRepository.findAll();
    }

    // Obtener un detalle de orden por su ID
    public Detalle_OrdenModel findById(String id_detalle_orden) {
        return detalle_ordenRepository.findById(id_detalle_orden).orElse(null);
    }

    // Crear un nuevo detalle de orden
    public Detalle_OrdenModel create(Detalle_OrdenModel detalle_orden) {
        return detalle_ordenRepository.save(detalle_orden);
    }

    // Actualizar un detalle de orden
    public Detalle_OrdenModel update(Detalle_OrdenModel detalle_orden) {
        return detalle_ordenRepository.save(detalle_orden);
    }

    // Eliminar un detalle de orden
    public boolean delete(String id_detalle_orden) {
        try {
            detalle_ordenRepository.deleteById(id_detalle_orden);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

