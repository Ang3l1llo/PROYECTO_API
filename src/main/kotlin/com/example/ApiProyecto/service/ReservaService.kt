package com.example.ApiProyecto.service

import com.example.ApiProyecto.repository.ReservaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReservaService {

    @Autowired
    private lateinit var reservaRepository: ReservaRepository
}