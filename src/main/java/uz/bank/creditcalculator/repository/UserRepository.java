package uz.bank.creditcalculator.repository;
// Created by: Ali Artukov
// Created time: 6/4/2021 5:07 PM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bank.creditcalculator.entity.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByPassportSeriesAndPassportNumber(String passportSeries, String passportNumber);

    Boolean existsByPassportSeriesAndPassportNumber(String passportSeries, String passportNumber);

}
