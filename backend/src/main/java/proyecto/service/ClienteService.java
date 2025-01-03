package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import proyecto.entities.ClienteEntity;
import proyecto.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Recupera todos los clientes
    public ResponseEntity<List<ClienteEntity>> findAll() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    // Recupera un cliente por su ID
    public ResponseEntity<ClienteEntity> findById(String id_cliente) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id_cliente);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Recupera un cliente por su nombre
    public ResponseEntity<ClienteEntity> findByName(String name) {
        Optional<ClienteEntity> cliente = clienteRepository.findByName(name);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crea un nuevo cliente
    public ResponseEntity<ClienteEntity> createUser(ClienteEntity cliente) {
        ClienteEntity createdCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(createdCliente);
    }

    // Recupera un cliente por su correo electrónico
    public ResponseEntity<ClienteEntity> findByEmail(String email) {
        Optional<ClienteEntity> cliente = clienteRepository.findByEmail(email);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualiza un cliente
    public ResponseEntity<ClienteEntity> update(ClienteEntity cliente) {
        if (!clienteRepository.existsById(cliente.getId_cliente())) {
            return ResponseEntity.notFound().build();
        }
        ClienteEntity updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    // Elimina un cliente por su ID
    public ResponseEntity<Void> delete(String id_cliente) {
        if (!clienteRepository.existsById(id_cliente)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(id_cliente);
        return ResponseEntity.noContent().build();
    }

    // Realiza el login de un cliente
    public ResponseEntity<Object> loginUser(String email, String password) {
        Optional<ClienteEntity> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent() && cliente.get().getContrasena().equals(password)) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.status(401).body("Unauthorized");
    }

    // Punto medio geográfico entre dos clientes
    /*
    public ResponseEntity<Object> puntoMedio(String id_cliente1, String id_cliente2) {
        Optional<ClienteEntity> cliente1 = clienteRepository.findById(id_cliente1);
        Optional<ClienteEntity> cliente2 = clienteRepository.findById(id_cliente2);

        if (cliente1.isPresent() && cliente2.isPresent()) {
            // Aquí puedes calcular el punto medio geográfico, utilizando las coordenadas de latitud y longitud
            return ResponseEntity.ok("Punto medio calculado correctamente");
        }

        return ResponseEntity.notFound().build();
    }
    */
}
