package uz.bank.creditcalculator.model;
// Created by: Ali Artukov
// Created time: 6/4/2021 11:45 PM
// Telegram: https://t.me/Ali_Artukov

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalculateDto {

    private String passportSeries;

    private String passportNumber;

    private Double salary;

    private Double creditAmount;

}
