package com.groupc.fourparks.infraestructure.rest.controller;

import com.groupc.fourparks.application.usecase.ManagerService;

import com.groupc.fourparks.infraestructure.model.dto.UserDto;
import com.groupc.fourparks.infraestructure.model.request.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(
        origins = {
                "http://localhost:3000",
                "http://192.168.0.5:3000"
        },
        allowCredentials = "true"
)
//@CrossOrigin(origins = "https://fourparks.vercel.app/")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(this.managerService.readUsers(), HttpStatus.OK);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDto>> getUserByRole(@PathVariable Long role) {
        return new ResponseEntity<>(this.managerService.userByRole(role), HttpStatus.OK);
    }

    @GetMapping("/freeAdmins")
    public ResponseEntity<List<UserDto>> getFreeAdmins() {
        return new ResponseEntity<>(this.managerService.getFreeAdmins(), HttpStatus.OK);
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<UserDto> getUser(@PathVariable String email) {
        return new ResponseEntity<>(this.managerService.getOneUser(email),HttpStatus.OK);
    }
    @GetMapping("/user/id/{id}")
    public ResponseEntity<UserDto> getUserId(@PathVariable Long id) {
        return new ResponseEntity<UserDto>(this.managerService.getOneUserId(id),HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/email/{email}")
    public void deleteUser( @PathVariable String email) {
        managerService.deleteUser(email);
    }

    @PutMapping("/user/update")
    public ResponseEntity<UserDto> modifyUser(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        return new ResponseEntity<>(this.managerService.modifyUser(userRegisterRequest), HttpStatus.OK);
    }
}
