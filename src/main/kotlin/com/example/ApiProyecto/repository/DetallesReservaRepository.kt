package com.example.ApiProyecto.repository

import com.example.ApiProyecto.model.DetallesReserva
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetallesReservaRepository : JpaRepository<DetallesReserva, Long> {
}