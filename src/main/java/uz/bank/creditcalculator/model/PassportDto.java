package uz.bank.creditcalculator.model;
// Created by: Ali Artukov
// Created time: 6/4/2021 11:27 PM
// Telegram: https://t.me/Ali_Artukov

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PassportDto {

    private String passportSeries;

    private String passportNumber;

}
