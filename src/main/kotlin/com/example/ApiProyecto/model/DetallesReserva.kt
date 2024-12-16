package com.example.ApiProyecto.model

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "detalles_reservas")
data class DetallesReserva (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var horaInicio: LocalTime? = null,

    @Column(nullable = false)
    var horaFin: LocalTime? = null,

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    var reserva: Reserva? = null
)