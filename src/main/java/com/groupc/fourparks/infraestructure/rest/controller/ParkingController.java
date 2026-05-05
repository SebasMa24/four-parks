package com.groupc.fourparks.infraestructure.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.fourparks.application.service.ParkingServiceImpl;
import com.groupc.fourparks.infraestructure.model.dto.CityDto;
import com.groupc.fourparks.infraestructure.model.dto.ParkingDto;
import com.groupc.fourparks.infraestructure.model.request.NewParkingRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parkings")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class ParkingController {
    private final ParkingServiceImpl parkingServiceImpl;

    @PostMapping("/parking/new")
    public ResponseEntity<ParkingDto> newParking(@RequestBody @Valid NewParkingRequest newParkingRequest){
        return new ResponseEntity<>(this.parkingServiceImpl.newParking(newParkingRequest), HttpStatus.OK);
    }

    @GetMapping("/parking/name/{name}")
    public ResponseEntity<ParkingDto> getParkingByName(@PathVariable String name) {
        return new ResponseEntity<>(this.parkingServiceImpl.getParking(name), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingDto>> getParkings() {
        return new ResponseEntity<>(this.parkingServiceImpl.getParkings(), HttpStatus.OK);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getCities() {
        return new ResponseEntity<>(this.parkingServiceImpl.getCities(), HttpStatus.OK);
    }

    @DeleteMapping("/parking/delete/name/{name}")
    public String deleteParking(@PathVariable String name) {
        return this.parkingServiceImpl.deleteParking(name);
    }

    @PutMapping("/parking/update")
    public ResponseEntity<ParkingDto> modifyParking(@RequestBody @Valid NewParkingRequest newParkingRequest){
        return new ResponseEntity<>(this.parkingServiceImpl.modifyParking(newParkingRequest), HttpStatus.OK);
    }

    @GetMapping("/parking/id/{id}")
    public ResponseEntity<ParkingDto> getParkingById(@PathVariable Long id) {
        return new ResponseEntity<>(this.parkingServiceImpl.getParkingById(id), HttpStatus.OK);
    }

}
