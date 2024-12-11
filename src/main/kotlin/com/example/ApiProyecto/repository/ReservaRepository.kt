package com.example.ApiProyecto.repository

import com.example.ApiProyecto.model.Reserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservaRepository : JpaRepository<Reserva, Long> {

}