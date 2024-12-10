package com.example.ApiProyecto.model

import jakarta.persistence.*
import java.sql.Date


@Entity
@Table(name = "reservas")
data class Reserva (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "fecha_reserva")
    val fecha_reserva: Date? = null,

    @Column(name = "espacio")
    val espacio: String? = null,

    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "id_usuario")
    val usuario: Long? = null
)