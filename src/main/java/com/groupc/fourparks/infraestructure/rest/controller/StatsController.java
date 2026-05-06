package com.groupc.fourparks.infraestructure.rest.controller;

import com.groupc.fourparks.application.usecase.AuditoryService;
import com.groupc.fourparks.application.usecase.StatsService;
import com.groupc.fourparks.infraestructure.model.dto.UserDto;

import com.groupc.fourparks.infraestructure.model.request.DateInfo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.time.ZoneId;
import java.sql.Date;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/stats")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://192.168.0.5:3000"
        },
        allowCredentials = "true"
)
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class StatsController {

    private final AuditoryService auditoryService;
    private final StatsService statsService;

    @PostMapping("/vehicleType/{id}")
    public ResponseEntity<String> vehicleType(@RequestBody @Valid DateInfo period, @PathVariable Long id) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return new ResponseEntity<>(this.statsService.vehicleType(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant()),
                id, period.getVehicleTypeCode()
        ), HttpStatus.OK);
    }

    @PostMapping("/usersCreatedOnDate")
    public ResponseEntity<List<UserDto>> usersCreatedOnDate(@RequestBody @Valid DateInfo period) {
        ZoneId defaultZoneId = ZoneId.systemDefault();


        return new ResponseEntity<>(this.auditoryService.usersOnDate(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant())), HttpStatus.OK);
    }

    @PostMapping("/getUsersForParking/{id}")
    public ResponseEntity<List<UserDto>> getUsersForParking(@RequestBody @Valid DateInfo period, @PathVariable Long id) {
        ZoneId defaultZoneId = ZoneId.systemDefault();

        return new ResponseEntity<>(this.statsService.getUsersForParking(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant()),
                id
        ), HttpStatus.OK);
    }

    @PostMapping("/reservationsOnDate/{id}")
    public ResponseEntity<String> reservationsOnDate(@RequestBody @Valid DateInfo period, @PathVariable Long id) {
        ZoneId defaultZoneId= ZoneId.systemDefault();

        return new ResponseEntity<>(this.statsService.reservationsOnDate(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant()),
                id
        ), HttpStatus.OK);
    }

    @PostMapping("/incomesOnDate/{id}")
    public ResponseEntity<String> incomesOnDate(@RequestBody @Valid DateInfo period, @PathVariable Long id) {
        ZoneId defaultZoneId = ZoneId.systemDefault();


        return new ResponseEntity<>(this.statsService.incomesOnDate(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant()), id), HttpStatus.OK);
    }


}
