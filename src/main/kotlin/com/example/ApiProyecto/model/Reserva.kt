package com.example.ApiProyecto.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "reservas")
data class Reserva (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var fecha_reserva: LocalDate? = null,

    @Column(nullable = false)
    var espacio: String? = null,

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario? = null,

    @OneToMany(mappedBy = "reserva", cascade = [CascadeType.ALL], orphanRemoval = true)
    var detalles: List<DetallesReserva> = mutableListOf()
)