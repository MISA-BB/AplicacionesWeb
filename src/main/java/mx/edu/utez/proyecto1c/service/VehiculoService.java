package mx.edu.utez.proyecto1c.service;

import mx.edu.utez.proyecto1c.controller.dto.VehiculoDTO;
import mx.edu.utez.proyecto1c.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    public double calcularRenta(VehiculoDTO dto) {


        if (dto.getEdadConductor() < 18) {
            throw new ReglaNegocioException("El conductor debe ser mayor de edad (18 años)");
        }
        if (dto.getDiasRenta() > 30) {
            throw new ReglaNegocioException("La renta no puede superar los 30 días");
        }
        if (dto.getKilometrosEstimados() > 5000) {
            throw new ReglaNegocioException("Los kilómetros no pueden superar los 5,000 km");
        }
        if (dto.getTipoVehiculo().equalsIgnoreCase("CAMIONETA") && dto.getEdadConductor() < 25) {
            throw new ReglaNegocioException("Para camioneta el conductor debe tener al menos 25 años");
        }

        double costoDiario = 0;
        String tipo = dto.getTipoVehiculo().toUpperCase();
        if (tipo.equals("COMPACTO")) costoDiario = 550;
        else if (tipo.equals("SEDAN")) costoDiario = 700;
        else if (tipo.equals("SUV")) costoDiario = 950;
        else if (tipo.equals("CAMIONETA")) costoDiario = 1200;

        double costoRenta = costoDiario * dto.getDiasRenta();

        double kmIncluidos = dto.getDiasRenta() * 100;
        double cargoKm = 0;
        if (dto.getKilometrosEstimados() > kmIncluidos) {
            cargoKm = (dto.getKilometrosEstimados() - kmIncluidos) * 4;
        }

        double cargoEdad = 0;
        if (dto.getEdadConductor() >= 18 && dto.getEdadConductor() <= 24) {
            cargoEdad = (costoRenta + cargoKm) * 0.15;
        }

        double cargoSeguro = dto.isSeguroCompleto() ? dto.getDiasRenta() * 180 : 0;


        double descuento = 0;
        if (dto.getDiasRenta() >= 7) {
            descuento = costoRenta * 0.10;
        }

        return (costoRenta - descuento) + cargoKm + cargoEdad + cargoSeguro;
    }
}