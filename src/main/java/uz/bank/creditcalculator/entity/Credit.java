package uz.bank.creditcalculator.entity;
// Created by: Ali Artukov
// Created time: 6/5/2021 2:04 AM
// Telegram: https://t.me/Ali_Artukov

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private Double creditRate;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    Users user;

    @Column(nullable = false)
    private boolean approved;

}
