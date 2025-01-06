package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.models.ClienteModel;
import proyecto.models.TarjetaModel;
import proyecto.service.ClienteService;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteModel>> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<ClienteModel> findById(@PathVariable ObjectId id_cliente) {
        return clienteService.findById(id_cliente);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteModel> findByEmail(@PathVariable String email) {
        return clienteService.findByEmail(email);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody ClienteModel user) {
        return clienteService.loginUser(user.getEmail(), user.getContrasena());
    }

    @PostMapping("/register")
    public ResponseEntity<ClienteModel> createUser(@RequestBody ClienteModel user) {
        return clienteService.createUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ClienteModel cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("/delete/{id_cliente}")
    public ResponseEntity<?> delete(@PathVariable ObjectId id_cliente) {
        return clienteService.delete(id_cliente);
    }

    @GetMapping("/getTarjetas/{email}")
    public ResponseEntity<List<TarjetaModel>> getTarjetas(@PathVariable String email) {
        return clienteService.getAllTarjetas(email);
    }

    @PostMapping("/addTarjeta/{email}")
    public ResponseEntity<?> addTarjeta(@PathVariable String email,
                                          @RequestBody TarjetaModel tarjeta){
        return clienteService.addTarjetas(email, tarjeta);
    }

    @PostMapping("/deleteTarjeta/{email}")
    public ResponseEntity<?> deleteTarjeta(@PathVariable String email,
                                        @RequestBody TarjetaModel tarjeta){
        return clienteService.deleteTarjeta(email, tarjeta);
    }
}
