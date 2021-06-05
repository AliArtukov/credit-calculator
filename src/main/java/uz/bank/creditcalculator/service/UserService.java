package uz.bank.creditcalculator.service;
// Created by: Ali Artukov
// Created time: 6/4/2021 5:08 PM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bank.creditcalculator.entity.Users;
import uz.bank.creditcalculator.model.ApiResponse;
import uz.bank.creditcalculator.model.PassportDto;
import uz.bank.creditcalculator.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * With the help of a series of passports, return information about the user.
     * @param passportDto PassportDto
     * @return ApiResponse
     */
    public ApiResponse getUserInfo(PassportDto passportDto) {
        Optional<Users> optionalUser = userRepository.findByPassportSeriesAndPassportNumber(passportDto.getPassportSeries(), passportDto.getPassportNumber());

        if (optionalUser.isPresent())
            return new ApiResponse(true, "User info:", optionalUser.get());
        return new ApiResponse(false, "User with such passport data was not found!!!");
    }

    /**
     * Using the serial number of the passport, first and last name, a user is created.
     * @param user Users
     * @return ApiResponse
     */
    public ApiResponse addUser(Users user) {
        Boolean exists = userRepository.existsByPassportSeriesAndPassportNumber(user.getPassportSeries(), user.getPassportNumber());

        if (exists)
            return new ApiResponse(false, "A user with such passport data already exists!!!");
        userRepository.save(user);
        return new ApiResponse(true, "User added.", user);
    }

}
