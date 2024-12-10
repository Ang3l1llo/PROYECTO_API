package com.example.ApiProyecto.service

import com.example.ApiProyecto.model.Usuario
import com.example.ApiProyecto.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository


    fun loadUserByUsername(username: String?): UserDetails {
        var usuario : Usuario = usuarioRepository.findByusername(username!!).orElseThrow {Exception("Usuario no encontrado")}

        return User
            .builder()
            .username(usuario.username)
            .password(usuario.password)
            .roles(usuario.role)//!!.split(",").toString()
            .build()
    }
}