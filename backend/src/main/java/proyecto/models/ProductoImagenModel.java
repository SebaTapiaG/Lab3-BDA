package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ProductoImagen")  // Define la colección en MongoDB
public class ProductoImagenModel {

    @Id
    private ObjectId id;  // ID único generado automáticamente por MongoDB

    @Field("id_producto")  // Nombre del campo en la base de datos
    private ObjectId idProducto;  // Relación con el producto correspondiente

    private String tipo;  // Indica si es "imagen" o "video"
    private String nombreArchivo;  // Nombre del archivo multimedia
    private String descripcion;  // Descripción del archivo (opcional)


    public ProductoImagenModel() {
    }

    public ProductoImagenModel(ObjectId idProducto, String tipo, String nombreArchivo, String descripcion) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.nombreArchivo = nombreArchivo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ObjectId idProducto) {
        this.idProducto = idProducto;
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
