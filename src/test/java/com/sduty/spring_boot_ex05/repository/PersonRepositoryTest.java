package com.sduty.spring_boot_ex05.repository;

import com.sduty.spring_boot_ex05.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("J");
        person.setAge(30);

        personRepository.save(person);

//        System.out.println(personRepository.findAll());

        List<Person> personList = personRepository.findAll();

        Assertions.assertThat(personList.size()).isEqualTo(1);
        Assertions.assertThat(personList.get(0).getName()).isEqualTo("J");
        Assertions.assertThat(personList.get(0).getAge()).isEqualTo(30);
    }
}
