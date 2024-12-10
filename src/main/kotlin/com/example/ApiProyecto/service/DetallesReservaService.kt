package com.example.ApiProyecto.service

import com.example.ApiProyecto.repository.DetallesReservaRepository
import com.example.ApiProyecto.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetallesReservaService {

    @Autowired
    private lateinit var detallesReservaRepository: DetallesReservaRepository

}