package mx.edu.utez.proyecto1c.controller.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvioDTO {

    @NotBlank(message = "El código postal es obligatorio")
    private String codigoPostal;

    @Min(value = 1, message = "El peso debe ser mayor a 0")
    private double pesoKg;

    @Min(value = 1, message = "El largo debe ser mayor a 0")
    private double largoCm;

    @Min(value = 1, message = "El ancho debe ser mayor a 0")
    private double anchoCm;

    @Min(value = 1, message = "El alto debe ser mayor a 0")
    private double altoCm;

    @NotBlank(message = "El tipo de envío es obligatorio")
    private String tipoEnvio;

    @Min(value = 0, message = "El valor declarado no puede ser negativo")
    private double valorDeclarado;
}