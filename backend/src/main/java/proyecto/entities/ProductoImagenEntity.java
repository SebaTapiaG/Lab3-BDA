package proyecto.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto_videos")  // Colección para almacenar los archivos multimedia
public class ProductoImagenEntity {

    @Id
    private String id;  // ID del archivo multimedia (MongoDB genera este ID automáticamente)

    private String id_producto;  // Referencia al producto al que pertenece el archivo
    private String tipo;  // Tipo de archivo (por ejemplo, "imagen", "video")
    private String nombreArchivo;  // Nombre del archivo multimedia
    private String descripcion;  // Descripción del archivo (opcional)

    // Constructor
    public ProductoImagenEntity(String id_producto, String tipo, String nombreArchivo, String descripcion) {
        this.id_producto = id_producto;
        this.tipo = tipo;
        this.nombreArchivo = nombreArchivo;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_productoImagen() {
        return id_producto;
    }

    public void setId_productoImagen(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
