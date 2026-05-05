package com.groupc.fourparks.infraestructure.rest.controller;

import com.groupc.fourparks.application.service.ReservationServiceImpl;
import com.groupc.fourparks.infraestructure.model.dto.ReservationDto;
import com.groupc.fourparks.infraestructure.model.request.ReservationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reservations")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    @PostMapping("/reservation/new")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationRequest reservation) {
        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.OK);
    }

    @DeleteMapping("reservation/delete/user/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("La reserva del usuario: " + id +  " se ha eliminado con éxito");
    }

    @PostMapping("/reservation/start")
    public ResponseEntity<ReservationDto> startReservation(@RequestBody ReservationRequest reservation) {
        return new ResponseEntity<>(reservationService.startReservation(reservation), HttpStatus.OK);
    }

    @PostMapping("/reservation/end")
    public ResponseEntity<ReservationDto> endReservation(@RequestBody ReservationRequest reservationEnd) {
        return new ResponseEntity<>(reservationService.endReservation(reservationEnd), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/parking/id/{id}")
    public ResponseEntity<List<ReservationDto>> getReservationByParkingId(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationsByParkingId(id), HttpStatus.OK);
    }

    @GetMapping("/reservation/id/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationById(id), HttpStatus.OK);
    }

    @GetMapping("/active/user/id/{id}")
    public ResponseEntity<List<ReservationDto>> getReservationActiveByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationsActiveByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/finish/user/id/{id}")
    public ResponseEntity<List<ReservationDto>> getReservationFinishByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationsFinishByUserId(id), HttpStatus.OK);
    }

}
