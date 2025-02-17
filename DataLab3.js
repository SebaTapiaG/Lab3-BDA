db.createCollection("productos");
db.createCollection("clientes");
db.createCollection("ordenes");
db.createCollection("repartidores");
db.createCollection("zonas");
db.createCollection("categorias");

// Insertar categorías
const categorias = [
    { nombre: "Electrónica" },
    { nombre: "Ropa" },
    { nombre: "Hogar" },
    { nombre: "Juguetes" },
    { nombre: "Deportes" }
];

categorias.forEach(categoria => {
    db.categorias.insertOne(categoria);
});

// Insertar clientes
const clientes = [
    { 
        nombre: "Juan Pérez", 
        contrasena: "password123", 
        direccion: "José Garrido 125", 
        comuna: "Maipú", 
        email: "juan.perez@example.com", 
        telefono: "123456789", 
        latitud: -33.455, 
        longitud: -70.655 
    },
    { 
        nombre: "Ana Gómez", 
        contrasena: "securepass456", 
        direccion: "Los viñedos 1675", 
        comuna: "San Felipe", 
        email: "ana.gomez@example.com", 
        telefono: "987654321", 
        latitud: -33.465, 
        longitud: -70.665 
    },
    { 
        nombre: "Carlos Ruiz", 
        contrasena: "mypassword789", 
        direccion: "Vicuña Mackenna 680", 
        comuna: "Peñaflor", 
        email: "carlos.ruiz@example.com", 
        telefono: "555666777", 
        latitud: -33.445, 
        longitud: -70.645 
    }
];

clientes.forEach(cliente => {
    db.clientes.insertOne(cliente);
});

// Insertar productos con categoría
const productos = [
    { 
        nombre: "Smartphone", 
        descripcion: "Teléfono inteligente de última generación", 
        precio: 699.99, 
        stock: 50, 
        estado: "disponible", 
        categoria: { id: 1, nombre: "Electrónica" } 
    },
    { 
        nombre: "Camiseta", 
        descripcion: "Camiseta 100% algodón", 
        precio: 19.99, 
        stock: 200, 
        estado: "disponible", 
        categoria: { id: 2, nombre: "Ropa" } 
    },
    { 
        nombre: "Sofá", 
        descripcion: "Sofá de 3 plazas", 
        precio: 499.99, 
        stock: 10, 
        estado: "disponible", 
        categoria: { id: 3, nombre: "Hogar" } 
    },
    { 
        nombre: "Pelota de fútbol", 
        descripcion: "Pelota oficial tamaño 5", 
        precio: 29.99, 
        stock: 100, 
        estado: "disponible", 
        categoria: { id: 5, nombre: "Deportes" } 
    },
    { 
        nombre: "Muñeca", 
        descripcion: "Muñeca interactiva con accesorios", 
        precio: 39.99, 
        stock: 25, 
        estado: "disponible", 
        categoria: { id: 4, nombre: "Juguetes" } 
    }
];

productos.forEach(producto => {
    db.productos.insertOne(producto);
});

// Insertar repartidores
const repartidores = [
    { nombre: "Juan Pérez", contrasena: "password123", email: "juan.perez@example.com", telefono: "987654321" },
    { nombre: "María González", contrasena: "securePass456", email: "maria.gonzalez@example.com", telefono: "912345678" },
    { nombre: "Carlos López", contrasena: "mySecret789", email: "carlos.lopez@example.com", telefono: "923456789" }
];

repartidores.forEach(repartidor => {
    db.repartidores.insertOne(repartidor);
});

// Insertar órdenes con detalles y relación por email
const ordenes = [
    { 
        fechaOrden: "2024-11-01T14:30:00", 
        estado: "completada", 
        emailCliente: "juan.perez@example.com", 
        total: 749.98, 
        latitud: -33.455, 
        longitud: -70.655, 
        detalles: [
            { producto: "Smartphone", cantidad: 1, precio: 699.99 },
            { producto: "Camiseta", cantidad: 2, precio: 19.99 }
        ]
    },
    { 
        fechaOrden: "2024-11-02T10:15:00", 
        estado: "completada", 
        emailCliente: "ana.gomez@example.com", 
        total: 29.99, 
        latitud: -33.465, 
        longitud: -70.665, 
        detalles: [
            { producto: "Pelota de fútbol", cantidad: 1, precio: 29.99 }
        ]
    },
    { 
        fechaOrden: "2024-11-03T18:45:00", 
        estado: "enviada", 
        emailCliente: "juan.perez@example.com", 
        total: 499.99, 
        latitud: -33.4489, 
        longitud: -70.6693, 
        detalles: [
            { producto: "Sofá", cantidad: 1, precio: 499.99 }
        ]
    }
];

ordenes.forEach(orden => {
    db.ordenes.insertOne(orden);
});

// Insertar zonas
const zonas = [
    { nombre: "Zona 1", estado: "Restringida", area: "POLYGON((-70.65 -33.45, -70.66 -33.45, -70.66 -33.46, -70.65 -33.46, -70.65 -33.45))" },
    { nombre: "Zona 2", estado: "Disponible", area: "POLYGON((-70.64 -33.44, -70.65 -33.44, -70.65 -33.45, -70.64 -33.45, -70.64 -33.44))" },
    { nombre: "Zona 3", estado: "Restringida", area: "POLYGON((-70.66 -33.46, -70.67 -33.46, -70.67 -33.47, -70.66 -33.47, -70.66 -33.46))" },
    { nombre: "Zona 4", estado: "Disponible", area: "POLYGON((-70.62 -33.42, -70.63 -33.42, -70.63 -33.43, -70.62 -33.43, -70.62 -33.42))" },
    { nombre: "Zona 5", estado: "Restringida", area: "POLYGON((-70.60 -33.40, -70.61 -33.40, -70.61 -33.41, -70.60 -33.41, -70.60 -33.40))" }
];

zonas.forEach(zona => {
    db.zonas.insertOne(zona);
});
