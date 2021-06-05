package uz.bank.creditcalculator.service;
// Created by: Ali Artukov
// Created time: 6/4/2021 11:49 PM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bank.creditcalculator.ProjectVariables;
import uz.bank.creditcalculator.entity.Credit;
import uz.bank.creditcalculator.entity.Users;
import uz.bank.creditcalculator.model.ApiResponse;
import uz.bank.creditcalculator.model.CalculateDto;
import uz.bank.creditcalculator.model.PassportDto;
import uz.bank.creditcalculator.repository.CreditRepository;

import java.util.Date;

@Service
public class CalculatorService {

    @Autowired
    UserService userService;

    @Autowired
    CreditRepository creditRepository;

    /**
     * With the help of passport data, salary and the desired amount of the loan,
     * return the result about the possibility of lending or refusing to lend.
     * @param calculateDto CalculateDto
     * @return ApiResponse
     */
    public ApiResponse calculateSalary(CalculateDto calculateDto) {
        ApiResponse apiResponse = userService.getUserInfo(new PassportDto(calculateDto.getPassportSeries(), calculateDto.getPassportNumber()));
        if (!apiResponse.isSuccess())
            return new ApiResponse(false, "User with such data was not found!!!");

        double annualProfit = (calculateDto.getSalary() * 12) - (((calculateDto.getSalary() * 12) / 100) * ProjectVariables.TAX_RATE);
        double creditSumma = (calculateDto.getCreditAmount() / 100) * ProjectVariables.CREDIT_RATE;

        Users user = (Users) apiResponse.getObj();
        Credit credit = new Credit();
        credit.setUser(user);
        credit.setSalary(calculateDto.getSalary());
        credit.setAmount(calculateDto.getCreditAmount());
        credit.setCreditRate(ProjectVariables.CREDIT_RATE);
        credit.setDate(new Date());
        credit.setApproved(annualProfit >= creditSumma);
        creditRepository.save(credit);

        if (annualProfit >= creditSumma)
            return new ApiResponse(true, "You can take out a credit.");

        double proposedCredit = annualProfit / 100;
        proposedCredit = (proposedCredit * ProjectVariables.CREDIT_RATE) + annualProfit;
        proposedCredit = proposedCredit / 100;
        proposedCredit = annualProfit / proposedCredit;
        proposedCredit = (annualProfit / 100) * proposedCredit;
        return new ApiResponse(false, "Due to the lack of your salary to repay the loan, we offer you a loan in the amount of " + proposedCredit);
    }

}
