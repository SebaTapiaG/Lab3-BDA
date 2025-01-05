package proyecto.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Orden") // Indica que esta clase representa una colección en MongoDB
public class OrdenModel {

    @Id // Identificador único en MongoDB
    private ObjectId id; // MongoDB utiliza un identificador de tipo String por defecto
    private Instant fechaOrden; // Usamos Instant para fechas en lugar de Timestamp
    private String estado; // Puede ser "pendiente", "pagada", "enviada", etc.
    private ObjectId idCliente; // Relación con el cliente (referencia)
    private double total; // Total a pagar
    private double latitud; // Coordenada geográfica
    private double longitud; // Coordenada geográfica
    private List<ProductoModel> productos; // Lista de productos en la orden


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Instant getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Instant fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ObjectId getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ObjectId idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public List<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoModel> productos) {
        this.productos = productos;
    }
}
