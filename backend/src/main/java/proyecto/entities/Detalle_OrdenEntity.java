package proyecto.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detalle_ordenes")  // Indica que esta clase será almacenada en la colección "detalle_ordenes"
public class Detalle_OrdenEntity {

    /* Atributos
    Campo Tipo de dato Descripción
    id_detalle String (PK) Identificador único del detalle de la orden
    id_orden String (FK) Clave foránea que referencia a la orden
    id_producto String (FK) Clave foránea que referencia al producto
    cantidad INT Cantidad del producto en la orden
    precio_unitario DECIMAL(10, 2) Precio unitario del producto
     */

    @Id  // Usamos @Id para marcar el campo como la clave primaria (_id en MongoDB)
    private String id_detalle; // Usamos String para el identificador, ya que MongoDB maneja el ObjectId

    private String id_orden;  // Referencia a la orden, utilizando el ObjectId de la orden
    private String id_producto;  // Referencia al producto, utilizando el ObjectId del producto
    private int cantidad;
    private double precio_unitario;

    // Constructor
    public Detalle_OrdenEntity(String id_detalle, String id_orden, String id_producto, int cantidad, double precio_unitario) {
        this.id_detalle = id_detalle;
        this.id_orden = id_orden;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    // Constructor vacío
    public Detalle_OrdenEntity() {}

    // Getters y setters
    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
