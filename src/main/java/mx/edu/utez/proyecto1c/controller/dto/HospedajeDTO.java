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
public class HospedajeDTO {

    @NotBlank(message = "El nombre del huésped es obligatorio")
    private String nombreHuesped;

    @NotBlank(message = "El tipo de habitación es obligatorio")
    private String tipoHabitacion;

    @Min(value = 1, message = "Mínimo 1 noche")
    private int numeroNoches;

    @Min(value = 1, message = "Mínimo 1 huésped")
    private int numeroHuespedes;

    @NotBlank(message = "La temporada es obligatoria")
    private String temporada;

    private boolean incluyeDesayuno;
    private boolean incluyeEstacionamiento;
}