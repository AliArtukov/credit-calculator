package uz.bank.creditcalculator.repository;
// Created by: Ali Artukov
// Created time: 6/5/2021 2:39 AM
// Telegram: https://t.me/Ali_Artukov

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bank.creditcalculator.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
