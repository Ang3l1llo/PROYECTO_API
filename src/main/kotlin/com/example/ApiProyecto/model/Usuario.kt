package com.example.ApiProyecto.model

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val username: String? = null,

    @Column(nullable = false)
    val password: String? = null,

    var role: String? = null // e.g., "ROLE_USER,ROLE_ADMIN"
)