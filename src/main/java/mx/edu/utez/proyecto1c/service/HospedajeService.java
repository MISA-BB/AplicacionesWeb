package mx.edu.utez.proyecto1c.service;

import mx.edu.utez.proyecto1c.controller.dto.HospedajeDTO;
import mx.edu.utez.proyecto1c.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class HospedajeService {

    public double calcularHospedaje(HospedajeDTO dto) {
        if (dto.getNumeroNoches() > 30) {
            throw new ReglaNegocioException("El número de noches no puede superar 30");
        }

        String hab = dto.getTipoHabitacion().toUpperCase();
        if (hab.equals("INDIVIDUAL") && dto.getNumeroHuespedes() > 1) {
            throw new ReglaNegocioException("La habitación individual es solo para 1 persona");
        }
        if (hab.equals("DOBLE") && dto.getNumeroHuespedes() > 2) {
            throw new ReglaNegocioException("La habitación doble admite máximo 2 personas");
        }
        if (hab.equals("SUITE") && dto.getNumeroHuespedes() > 4) {
            throw new ReglaNegocioException("La suite admite máximo 4 personas");
        }

        double costoNoche = 0;
        if (hab.equals("INDIVIDUAL")) costoNoche = 700;
        else if (hab.equals("DOBLE")) costoNoche = 1100;
        else if (hab.equals("SUITE")) costoNoche = 1800;

        double costoBase = costoNoche * dto.getNumeroNoches();

        double ajusteTemporada = 0;
        if (dto.getTemporada().equalsIgnoreCase("BAJA")) {
            ajusteTemporada = - (costoBase * 0.10);
        } else if (dto.getTemporada().equalsIgnoreCase("ALTA")) {
            ajusteTemporada = costoBase * 0.25;
        }

        double descuentoEstancia = 0;
        if (dto.getNumeroNoches() >= 7) {
            descuentoEstancia = costoBase * 0.08;
        }

        double subtotalHospedaje = costoBase + ajusteTemporada - descuentoEstancia;

        double desayuno = dto.isIncluyeDesayuno() ? (dto.getNumeroHuespedes() * dto.getNumeroNoches() * 150) : 0;
        double estacionamiento = dto.isIncluyeEstacionamiento() ? (dto.getNumeroNoches() * 100) : 0;

        double impuesto = subtotalHospedaje * 0.04;

        return subtotalHospedaje + desayuno + estacionamiento + impuesto;
    }
}