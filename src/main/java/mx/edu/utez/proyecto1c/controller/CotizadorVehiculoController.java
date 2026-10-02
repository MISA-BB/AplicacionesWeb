package mx.edu.utez.proyecto1c.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.dto.VehiculoDTO;
import mx.edu.utez.proyecto1c.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/vehiculos")
public class CotizadorVehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/cotizar")
    public ResponseEntity<String> cotizar(@RequestBody @Valid VehiculoDTO payload) {
        double total = vehiculoService.calcularRenta(payload);
        return ResponseEntity
                .status(200)
                .body("El importe total a pagar para " + payload.getNombreCliente() + " es: $" + total);
    }
}