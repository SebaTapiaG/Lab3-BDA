package proyecto.controllers;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.dto.RepartidorDTO;
import proyecto.models.OrdenModel;
import proyecto.service.OrdenService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orden")
public class OrdenController {

   private final OrdenService ordenService;
   public OrdenController(OrdenService ordenService) {
       this.ordenService = ordenService;
    }

    @GetMapping("")
    public ResponseEntity<List<OrdenModel>> findAll(){
        return ordenService.findAll();
    }

    @GetMapping("/{id_orden}")
    public ResponseEntity<?> findById(@PathVariable ObjectId id_orden) {
        return ordenService.findById(id_orden);
    }

    @PostMapping("/create")
    public ResponseEntity<OrdenModel> create(@RequestBody OrdenModel orden) {
       System.out.println(orden);
       return ordenService.create(orden);
    }

    @PutMapping("/update")
    public ResponseEntity<OrdenModel> update(@RequestBody OrdenModel orden) {
        return ordenService.update(orden);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(ObjectId id_orden) {
        return ordenService.delete(id_orden);
    }

    @GetMapping("/findByCliente/{email}")
    public ResponseEntity<List<OrdenModel>> findByCliente(@PathVariable String email) {
        return ResponseEntity.ok(ordenService.findByEmailCliente(email));
    }

    /*
    @PutMapping("/updateEstado/{id_orden}/{estado}")
    public ResponseEntity<Object> updateEstado(@PathVariable int id_orden, @PathVariable String estado) {
        return ordenService.updateEstado(id_orden, estado);
    }

    @GetMapping("/findDeliveryCompletedInArea/{id_zona}")
    public ResponseEntity<List<RepartidorDTO>> findDeliveryCompletedInArea(@PathVariable int id_zona){
        return ordenService.findDeliveryCompletedInArea(id_zona);
    }

     */

}
