package com.groupc.fourparks.infraestructure.rest.controller;

import com.groupc.fourparks.application.usecase.AuditoryService;
import com.groupc.fourparks.domain.model.Auditory;
import com.groupc.fourparks.infraestructure.model.dto.AuditoryDto;
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
@RequestMapping("/api/v1/auditory")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://192.168.0.5:3000"
        },
        allowCredentials = "true"
)
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class AuditoryController {

    private final AuditoryService auditoryService;


    @PostMapping("/usersCreatedOnDate")
    public ResponseEntity<List<UserDto>> usersCreatedOnDate(@RequestBody @Valid DateInfo period) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return new ResponseEntity<>(this.auditoryService.usersOnDate(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant())), HttpStatus.OK);
    }

    @PostMapping("/getAuditories/{id}")
    public ResponseEntity<List<AuditoryDto>> getAuditories(@RequestBody @Valid DateInfo period, @PathVariable Long id) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return new ResponseEntity<>(this.auditoryService.getAuditories(
                Date.from(period.getBeginning().atStartOfDay(defaultZoneId).toInstant()),
                Date.from(period.getEnding().atStartOfDay(defaultZoneId).toInstant()), id), HttpStatus.OK);
    }

}
