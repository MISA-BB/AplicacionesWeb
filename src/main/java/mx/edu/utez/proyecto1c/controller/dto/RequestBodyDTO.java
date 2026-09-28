package mx.edu.utez.proyecto1c.controller.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RequestBodyDTO {

    //recibe los datos del dto del body el json sus datos y su formate


    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe de tener al menos 3 caracteres")
    private String nombre;

    @Min(value = 18, message = "la edad minima es de 18")
    private int edad;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es valido")
    private String correo;

    @NotBlank(message = "El curp es obligatorio")
    @Pattern(
            regexp = "^[A-Z][AEIOUX][A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TL|TS|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]\\d$",
            message = "La CURP no tiene un formato válido"
    )
    private String curp;
}
