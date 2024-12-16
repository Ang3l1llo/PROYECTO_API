package com.example.ApiProyecto.service

import com.example.ApiProyecto.model.DetallesReserva
import com.example.ApiProyecto.repository.DetallesReservaRepository
import com.example.ApiProyecto.repository.ReservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetallesReservaService {

    @Autowired
    private lateinit var detallesReservaRepository: DetallesReservaRepository

    @Autowired
    private lateinit var reservaRepository: ReservaRepository

    fun getDetailsById(idReserva: Long): List<DetallesReserva> {
        val reserva = reservaRepository.findById(idReserva).orElse(null)
            ?: throw Exception("Reserva no encontrada")
        return reserva.detalles
    }

    fun addDetailsToReservation(idReserva: Long, detalle: DetallesReserva): DetallesReserva {
        val reserva = reservaRepository.findById(idReserva).orElse(null)
            ?: throw Exception("Reserva no encontrada")

        if (detalle.horaInicio == null || detalle.horaFin == null) {
            throw Exception("Las horas de inicio y fin no pueden ser nulas")
        }
        if (detalle.horaInicio!!.isAfter(detalle.horaFin)) {
            throw Exception("La hora de inicio no puede ser posterior a la hora de fin")
        }

        detalle.reserva = reserva
        return detallesReservaRepository.save(detalle)
    }
}