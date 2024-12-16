package com.example.ApiProyecto.service

import com.example.ApiProyecto.model.Reserva
import com.example.ApiProyecto.repository.ReservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReservaService {

    @Autowired
    private lateinit var reservaRepository: ReservaRepository

    fun registerReservation(reservation: Reserva): Reserva{
        if(reservaRepository.findByfechaReserva(reservation.fechaReserva!!).isNotEmpty()
            && reservaRepository.findByEspacio(reservation.espacio!!).isNotEmpty()){
            throw Exception("Esa fecha de ese espacio ya esta reservada")
        }
        return reservaRepository.save(reservation)
    }

    fun existsById(id: Long?): Boolean {
        val existingReservation = reservaRepository.findById(id!!)

        return existingReservation.isPresent
    }

    fun getReservationById(id: Long): Reserva? {
        return reservaRepository.findById(id).orElse(null)
    }

    fun getReservations(): List<Reserva>{
        return reservaRepository.findAll()
    }

    fun deleteById(id: Long): Reserva? {
        val deleteReservation : Reserva? = reservaRepository.findByIdOrNull(id)
        reservaRepository.deleteById(id)
        return deleteReservation
    }
}