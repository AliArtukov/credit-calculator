package uz.bank.creditcalculator.controller;
// Created by: Ali Artukov
// Created time: 6/4/2021 5:01 PM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.creditcalculator.entity.Users;
import uz.bank.creditcalculator.model.ApiResponse;
import uz.bank.creditcalculator.model.PassportDto;
import uz.bank.creditcalculator.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * With the help of a series of passports, return information about the user.
     * @param passportDto PassportDto
     * @return ResponseEntity<?>
     */
    @GetMapping
    public ResponseEntity<?> getUserInfo(@RequestBody PassportDto passportDto){
        ApiResponse apiResponse = userService.getUserInfo(passportDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * Using the serial number of the passport, first and last name, a user is created.
     * @param user Users
     * @return ResponseEntity<?>
     */
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Users user){
        ApiResponse apiResponse = userService.addUser(user);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

}
