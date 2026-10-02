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
public class VehiculoDTO {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;

    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private int edadConductor;

    @NotBlank(message = "El tipo de vehículo es obligatorio")
    private String tipoVehiculo;

    @Min(value = 1, message = "Los días de renta deben ser al menos 1")
    private int diasRenta;

    @Min(value = 0, message = "Los kilómetros estimados no pueden ser negativos")
    private double kilometrosEstimados;

    private boolean seguroCompleto;
}