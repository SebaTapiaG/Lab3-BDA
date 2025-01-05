package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductoImagen")  // Colección para almacenar los archivos multimedia
public class ProductoImagenModel {

    @Id
    private ObjectId id;  // ID del archivo multimedia (MongoDB genera este ID automáticamente)

    private ObjectId id_producto;  // Referencia al producto al que pertenece el archivo
    private String tipo;  // Tipo de archivo (por ejemplo, "imagen", "video")
    private String nombreArchivo;  // Nombre del archivo multimedia
    private String descripcion;  // Descripción del archivo (opcional)

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId_producto() {
        return id_producto;
    }

    public void setId_producto(ObjectId id_producto) {
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
