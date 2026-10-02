package mx.edu.utez.proyecto1c.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.dto.HospedajeDTO;
import mx.edu.utez.proyecto1c.service.HospedajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/hospedaje")
public class CotizadorHospedajeController {

    @Autowired
    private HospedajeService hospedajeService;

    @PostMapping("/cotizar")
    public ResponseEntity<String> cotizar(@RequestBody @Valid HospedajeDTO payload) {
        double total = hospedajeService.calcularHospedaje(payload);
        return ResponseEntity
                .status(200)
                .body("El costo total del hospedaje para " + payload.getNombreHuesped() + " es: $" + total);
    }
}