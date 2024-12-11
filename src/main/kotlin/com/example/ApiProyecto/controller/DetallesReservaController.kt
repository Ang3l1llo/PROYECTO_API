package com.example.ApiProyecto.controller

import com.example.ApiProyecto.model.Reserva
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/detalles_reservas")
class DetallesReservaController {

    @GetMapping("/{id_reserva}")
    fun getReservaById(@PathVariable id: Long): ResponseEntity<Reserva>? {
        return null
    }
}