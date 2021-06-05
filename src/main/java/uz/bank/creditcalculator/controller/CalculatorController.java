package uz.bank.creditcalculator.controller;
// Created by: Ali Artukov
// Created time: 6/4/2021 11:41 PM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.creditcalculator.model.ApiResponse;
import uz.bank.creditcalculator.model.CalculateDto;
import uz.bank.creditcalculator.service.CalculatorService;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    /**
     * With the help of passport data, salary and the desired amount of the loan,
     * return the result about the possibility of lending or refusing to lend.
     * @param calculateDto CalculateDto
     * @return ResponseEntity<?>
     */
    @GetMapping
    public ResponseEntity<?> calculateSalary(@RequestBody CalculateDto calculateDto){
        ApiResponse apiResponse = calculatorService.calculateSalary(calculateDto);
        return ResponseEntity.ok(apiResponse);
    }

}
