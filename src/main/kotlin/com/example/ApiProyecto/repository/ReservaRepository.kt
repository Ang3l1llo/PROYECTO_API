package com.example.ApiProyecto.repository

import com.example.ApiProyecto.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface ReservaRepository : JpaRepository<Reserva, Long> {

    fun findByEspacio(espacio: String): List<Reserva>

    fun findByfechaReserva(fechaReserva: LocalDate): List<Reserva>


}