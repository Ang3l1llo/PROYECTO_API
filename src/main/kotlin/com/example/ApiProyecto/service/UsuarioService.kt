package com.example.ApiProyecto.service

import com.example.ApiProyecto.model.Usuario
import com.example.ApiProyecto.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Service
class UsuarioService: UserDetailsService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    override fun loadUserByUsername(username: String?): UserDetails {
        var usuario : Usuario = usuarioRepository.findByusername(username!!).orElseThrow {Exception("Usuario no encontrado")}

        return User
            .builder()
            .username(usuario.username)
            .password(usuario.password)
            .roles(usuario.role)
            .build()
    }

    fun registerUser(user: Usuario): Usuario {
        val existingUser = usuarioRepository.findByusername(user.username!!)
        if (existingUser.isPresent) {
            throw Exception("Usuario ya existente")
        }

        user.password = passwordEncoder.encode(user.password)

        return usuarioRepository.save(user)
    }

    fun existsByusername(username: String?): Boolean {
        val existingUser = usuarioRepository.findByusername(username!!)
        return existingUser.isPresent
    }

    fun getUserById(id: Long): Usuario? {
        return usuarioRepository.findById(id).orElse(null)
    }

}