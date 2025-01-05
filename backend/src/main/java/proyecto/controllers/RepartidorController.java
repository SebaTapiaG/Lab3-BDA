package proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.models.RepartidorModel;
import proyecto.service.RepartidorService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/repartidor")
public class RepartidorController {
    @Autowired
    private RepartidorService repartidorService;

    @GetMapping("")
    public ResponseEntity<List<Object>> findAll(){
        return (ResponseEntity<List<Object>>) repartidorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RepartidorModel> getById(@PathVariable Integer id){
        return repartidorService.findById(id);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email){
        return repartidorService.findByEmail(email);
    }

    @GetMapping("/almacen/{id}")
    public ResponseEntity<List<RepartidorModel>> findByAlmacen(@PathVariable Integer id){
        return repartidorService.findByAlmacen(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody RepartidorModel repartidor){
        return repartidorService.update(repartidor);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        return repartidorService.delete(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RepartidorModel repartidor){
        return repartidorService.register(repartidor);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody RepartidorModel repartidor){
        return repartidorService.login(repartidor);
    }

}
