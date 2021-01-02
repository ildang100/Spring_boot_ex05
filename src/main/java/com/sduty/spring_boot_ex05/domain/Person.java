package com.sduty.spring_boot_ex05.domain;

import com.sduty.spring_boot_ex05.domain.dto.Birthday;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String bloodType;

    private String hobby;

    private String address;

    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne
    private Block block;

}
