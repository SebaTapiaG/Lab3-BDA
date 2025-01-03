package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.entities.ProductoImagenEntity;
import proyecto.repositories.ProductoImagenRepository;

import java.util.List;

@Service
public class ProductoImagenService {

    @Autowired
    private ProductoImagenRepository productoImagenRepository;

    // Obtener todas las imágenes de un producto específico
    public List<ProductoImagenEntity> obtenerImagenesPorProducto(String id_producto) {
        return productoImagenRepository.findById_producto(id_producto);
    }

    // Obtener todas las imágenes por su tipo (imagen o video)
    public List<ProductoImagenEntity> obtenerImagenesPorTipo(String tipo) {
        return productoImagenRepository.findByTipo(tipo);
    }

    // Obtener imagen por nombre de archivo
    public List<ProductoImagenEntity> obtenerImagenesPorNombreArchivo(String nombreArchivo) {
        return productoImagenRepository.findByNombreArchivo(nombreArchivo);
    }

    // Obtener imagen por descripción
    public List<ProductoImagenEntity> obtenerImagenesPorDescripcion(String descripcion) {
        return productoImagenRepository.findByDescripcion(descripcion);
    }
}
