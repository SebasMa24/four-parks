package com.groupc.fourparks.infraestructure.rest.controller;

import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.groupc.fourparks.application.service.UserDetailsServiceImpl;
import com.groupc.fourparks.infraestructure.model.dto.UserDto;
import com.groupc.fourparks.infraestructure.model.dto.LoginDto;
import com.groupc.fourparks.infraestructure.model.request.UserNewPasswordRequest;
import com.groupc.fourparks.infraestructure.model.request.UserRegisterRequest;
import com.groupc.fourparks.infraestructure.model.request.UserLoginRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://192.168.0.5:3000"
        },
        allowCredentials = "true"
)
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        return new ResponseEntity<>(this.userDetailsService.createUser(userRegisterRequest), HttpStatus.CREATED);
    }

    @PostMapping("/log-in")
    public ResponseEntity<LoginDto> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userLoginRequest), HttpStatus.OK);
    }

    @PostMapping("/new-password")
    public ResponseEntity<UserDto> newPassword(@RequestBody @Valid UserNewPasswordRequest userNewPasswordRequest){
        return new ResponseEntity<>(this.userDetailsService.newPassword(userNewPasswordRequest), HttpStatus.OK);
    }

    @PostMapping("/unlock")
    public ResponseEntity<UserDto> unlock(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return new ResponseEntity<>(this.userDetailsService.unlock(userLoginRequest), HttpStatus.OK);
    }
}
