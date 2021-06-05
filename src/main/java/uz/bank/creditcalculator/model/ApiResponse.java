package uz.bank.creditcalculator.model;
// Created by: Ali Artukov
// Created time: 6/4/2021 5:08 PM
// Telegram: https://t.me/Ali_Artukov


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {

    private boolean success;

    private String message;

    private Object obj;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
