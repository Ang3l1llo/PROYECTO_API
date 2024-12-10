package com.example.ApiProyecto.model

import jakarta.persistence.*
import java.sql.Time

@Entity
@Table(name = "detalles_reservas")
data class DetallesReserva (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val hora_inicio: Time? = null,

    @Column(nullable = false)
    val hora_fin: Time? = null,

    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "id_reserva")
    val reserva: Long? = null
)