package com.example.ApiProyecto.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService {

    @Autowired
    private lateinit var jwtEncoder: JwtEncoder

    fun generarToken(authentication: Authentication): String {

        // Obtenemos los roles en un formato de cadena, separados por espacios
        val roles: String = authentication
            .authorities
            .joinToString(" ") { it.authority }

        val payload = JwtClaimsSet.builder()
            .issuer("self") // Emisor del token
            .issuedAt(Instant.now()) // Tiempo de emisión
            .expiresAt(Instant.now().plus(1, ChronoUnit.HOURS)) // Expiración
            .subject(authentication.name) // Usuario autenticado
            .claim("roles", roles) // Agregamos los roles como un claim adicional
            .build()

        // Codificamos el token y devolvemos su valor
        return jwtEncoder.encode(JwtEncoderParameters.from(payload)).tokenValue
    }
}