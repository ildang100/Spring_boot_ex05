package com.sduty.spring_boot_ex05.repository;

import com.sduty.spring_boot_ex05.domain.Person;
import com.sduty.spring_boot_ex05.service.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

//    List<Person> findByBlockIsNull();
//
//    List<Person> findByBloodType(String bloodType);

}
