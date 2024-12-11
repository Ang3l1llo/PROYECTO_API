package com.example.ApiProyecto.controller

import com.example.ApiProyecto.model.Reserva
import com.example.ApiProyecto.model.Usuario
import com.example.ApiProyecto.service.ReservaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/reservas")
class ReservaController {

    @Autowired
    private lateinit var reservaService: ReservaService

    @PostMapping
    fun createReservation(@RequestBody newReservation: Reserva): ResponseEntity<Reserva> {
        if(reservaService.existsById(newReservation.id)){
            return ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }
        val reservationDone = reservaService.registerReservation(newReservation)

        return ResponseEntity(reservationDone, HttpStatus.CREATED)
    }

    @GetMapping
    fun getReservations(): ResponseEntity<List<Reserva>> {
        return ResponseEntity.ok(reservaService.getReservations())
    }

    @GetMapping("/{id}")
    fun getReservationById(@PathVariable id: Long): ResponseEntity<Reserva>? {
        val reservation = reservaService.getReservationById(id)
        if(reservation != null){
            return ResponseEntity(reservation, HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteReserva(@PathVariable id: Long): ResponseEntity<Reserva> {
        val reservation = reservaService.getReservationById(id)
        if(reservation != null){
            reservaService.deleteById(id)
            return ResponseEntity(reservation,HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}