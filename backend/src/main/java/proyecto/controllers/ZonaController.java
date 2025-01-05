package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.models.ZonaModel;
import proyecto.service.ZonaService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/zona")
public class ZonaController {

    private final ZonaService zonaService;

    public ZonaController(ZonaService zonaService){
        this.zonaService = zonaService;
    }


    @GetMapping("")
    public ResponseEntity<List<Object>> findAll(){
        return (ResponseEntity<List<Object>>) zonaService.findAll();
    }

    @GetMapping("/{id_zona}")
    public ResponseEntity<Object> findById(@PathVariable ObjectId id_zona) {
        Optional<ZonaModel> zona = zonaService.findById(id_zona);
        return zona.<ResponseEntity<Object>>map(zonaModel -> new ResponseEntity<>(zonaModel, HttpStatus.OK)).orElse(null);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Object>> findByEstado(@PathVariable String estado){
        return zonaService.findByEstado(estado);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ZonaModel zona){
        return zonaService.create(zona);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ZonaModel zona){
        return zonaService.update(zona);
    }

    @DeleteMapping("/delete/{id_zona}")
    public ResponseEntity<Object> delete(@PathVariable ObjectId id_zona){
        return zonaService.delete(id_zona);
    }
}
