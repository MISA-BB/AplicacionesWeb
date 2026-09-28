package mx.edu.utez.proyecto1c.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.dto.EjercicioDTO;
import mx.edu.utez.proyecto1c.controller.dto.RequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/my-server")
public class MyController {

    @GetMapping
    public String miPrimerServicio () {
        return "Hola Mundo";
    }

    @GetMapping("/servicio2")
    public String servicio2 () {
        return "servicio2 ";
    }

    @PostMapping
    public String servico3 () {
        return "servico3";
    }

    @GetMapping("/path/{id}")
    public String PathVariable (@PathVariable String id) {
        return "El valor recibido fue: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> Body (@RequestBody @Valid RequestBodyDTO paylead) {
        System.out.println(paylead.getNombre());
        System.out.println(paylead.getEdad());
        System.out.println(paylead.getCorreo());
        System.out.println(paylead.getCurp());
        return ResponseEntity
                .status(201)
                .body(paylead);
    }

    @PostMapping("/fizzbuzz")
    public ResponseEntity<String> fizzBuzz(@RequestBody @Valid EjercicioDTO paylead) {
        for (int i = 1; i <= paylead.getNumero(); i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return ResponseEntity
                .status(201)
                .body(paylead.getNombre());
    }

    @PostMapping("/fibonacci")
    public ResponseEntity<String> fibonacci(@RequestBody @Valid EjercicioDTO paylead) {
        int n = paylead.getNumero();
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println(a);
            } else if (i == 1) {
                System.out.println(b);
            } else {
                int siguiente = a + b;
                System.out.println(siguiente);
                a = b;
                b = siguiente;
            }
        }
        return ResponseEntity
                .status(201)
                .body(paylead.getNombre());
    }
}