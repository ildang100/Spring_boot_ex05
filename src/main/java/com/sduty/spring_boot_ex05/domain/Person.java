package com.sduty.spring_boot_ex05.domain;

import com.sduty.spring_boot_ex05.domain.dto.Birthday;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Component
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String bloodType;

    private String hobby;

    private String address;

//    @Embedded
    private LocalDate birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne
    private Block block;

}
