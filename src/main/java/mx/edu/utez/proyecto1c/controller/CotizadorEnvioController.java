package mx.edu.utez.proyecto1c.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.dto.EnvioDTO;
import mx.edu.utez.proyecto1c.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/envios")
public class CotizadorEnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping("/cotizar")
    public ResponseEntity<String> cotizar(@RequestBody @Valid EnvioDTO payload) {
        double total = envioService.calcularCosto(payload);
        return ResponseEntity
                .status(200)
                .body("El costo total de envío para el C.P. " + payload.getCodigoPostal() + " es: $" + total);
    }
}