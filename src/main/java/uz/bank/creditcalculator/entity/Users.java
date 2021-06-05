package uz.bank.creditcalculator.entity;
// Created by: Ali Artukov
// Created time: 6/4/2021 4:49 PM
// Telegram: https://t.me/Ali_Artukov

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"passportSeries", "passportNumber"})})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String passportSeries;

    @Column(nullable = false)
    private String passportNumber;

}
