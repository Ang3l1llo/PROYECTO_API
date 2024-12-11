package com.example.ApiProyecto.service

import com.example.ApiProyecto.model.Reserva
import com.example.ApiProyecto.model.Usuario
import com.example.ApiProyecto.repository.ReservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ReservaService {

    @Autowired
    private lateinit var reservaRepository: ReservaRepository

    fun registerReservation(reservation: Reserva): Reserva{
        val existingReservation = reservaRepository.findById(reservation.id!!)
        if (existingReservation.isPresent){
            throw Exception("Reserva ya existente")
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