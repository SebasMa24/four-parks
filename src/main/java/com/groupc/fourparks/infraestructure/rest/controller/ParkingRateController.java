package com.groupc.fourparks.infraestructure.rest.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.fourparks.application.service.ParkingRateServiceImpl;
import com.groupc.fourparks.infraestructure.model.dto.ParkingRateDto;
import com.groupc.fourparks.infraestructure.model.request.ParkingRateRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/rates")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://192.168.0.5:3000"
        },
        allowCredentials = "true"
)
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class ParkingRateController {
    private final ParkingRateServiceImpl parkingRateServiceImpl;

    @PostMapping("/rate/new")
    public ResponseEntity<ParkingRateDto> newSlot(@RequestBody @Valid ParkingRateRequest parkingRateRequest) throws BadRequestException{
        return new ResponseEntity<>(this.parkingRateServiceImpl.newParkingRate(parkingRateRequest), HttpStatus.OK);
    }

    @GetMapping("/rate/id/{id}")
    public ResponseEntity<ParkingRateDto> getSlot(@PathVariable(required = true) String id) {
        return new ResponseEntity<>(this.parkingRateServiceImpl.getParkingRate(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping("/parking/id/{id}")
    public ResponseEntity<List<ParkingRateDto>> getSlotsByParking(@PathVariable(required = true) String id) {
        return new ResponseEntity<>(this.parkingRateServiceImpl.getParkingRatesByParking(Long.parseLong(id)), HttpStatus.OK);
    }

    @DeleteMapping("/rate/delete/{id}")
    public String deleteSlot(@PathVariable(required = true) String id) {
        return this.parkingRateServiceImpl.deleteParkingRate(Long.parseLong(id));
    }

    @PutMapping("/rate/update")
    public ResponseEntity<ParkingRateDto> modifySlot(@RequestBody @Valid ParkingRateRequest parkingRateRequest){
        return new ResponseEntity<>(this.parkingRateServiceImpl.modifyParkingRate(parkingRateRequest), HttpStatus.OK);
    }
}
