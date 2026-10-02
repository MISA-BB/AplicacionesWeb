package mx.edu.utez.proyecto1c.service;

import mx.edu.utez.proyecto1c.controller.dto.EnvioDTO;
import mx.edu.utez.proyecto1c.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    public double calcularCosto(EnvioDTO dto) {
        double volumen = dto.getLargoCm() * dto.getAnchoCm() * dto.getAltoCm();

        if (dto.getPesoKg() > 50) {
            throw new ReglaNegocioException("El paquete no puede pesar más de 50 kg");
        }
        if (dto.getLargoCm() > 150 || dto.getAnchoCm() > 150 || dto.getAltoCm() > 150) {
            throw new ReglaNegocioException("Las dimensiones no pueden superar los 150 cm");
        }
        if (volumen > 1000000) {
            throw new ReglaNegocioException("El volumen no puede superar los 1,000,000 cm³");
        }


        double costo = 80.0;
        costo += dto.getPesoKg() * 12.0;

        if (volumen > 50000) {
            costo += 100.0;
        }

        if (dto.getTipoEnvio().equalsIgnoreCase("EXPRESS")) {
            costo += costo * 0.40;
        } else if (dto.getTipoEnvio().equalsIgnoreCase("MISMO_DIA")) {
            costo += costo * 0.70;
        }

        if (dto.getValorDeclarado() > 10000) {
            costo += dto.getValorDeclarado() * 0.02;
        }

        return costo;
    }
}