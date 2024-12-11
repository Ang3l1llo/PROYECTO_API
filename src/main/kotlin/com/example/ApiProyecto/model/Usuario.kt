package com.example.ApiProyecto.model

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var username: String? = null,

    @Column(nullable = false)
    var password: String? = null,

    var role: String? = null, //USER o ADMIN

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var reservas: List<Reserva> = mutableListOf()
)