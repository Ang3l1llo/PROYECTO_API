package com.example.ApiProyecto.controller

import com.example.ApiProyecto.model.DetallesReserva
import com.example.ApiProyecto.service.DetallesReservaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/detalles_reservas")
class DetallesReservaController {

    @Autowired
    private lateinit var detallesReservaService: DetallesReservaService

    @GetMapping("/{id_reserva}")
    fun getDetailsById(@PathVariable id_reserva: Long): ResponseEntity<List<DetallesReserva>> {
        val detalles = detallesReservaService.getDetailsById(id_reserva)
        return if (detalles.isNotEmpty()) {
            ResponseEntity(detalles, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/{id_reserva}")
    fun addDetailsToReservation(@PathVariable id_reserva: Long,
                            @RequestBody detalle: DetallesReserva): ResponseEntity<DetallesReserva> {
        val nuevoDetalle = detallesReservaService.addDetailsToReservation(id_reserva, detalle)
        return ResponseEntity(nuevoDetalle, HttpStatus.CREATED)
    }
}