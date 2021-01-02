package com.sduty.spring_boot_ex05.repository;

import com.sduty.spring_boot_ex05.domain.Person;
import com.sduty.spring_boot_ex05.service.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday and person.birthday.dayOfBirthday = :dayOfBirthday")
    List<Person> findByBirthday(@Param("monthOfBirthday") int monthOfBirthday, @Param("dayOfBirthday") int dayOfBirthday);
}
