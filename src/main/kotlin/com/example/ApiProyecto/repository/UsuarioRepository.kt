package com.example.ApiProyecto.repository

import com.example.ApiProyecto.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByusername(username : String): Optional<Usuario>
}