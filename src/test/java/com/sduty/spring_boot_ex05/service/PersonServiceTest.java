package com.sduty.spring_boot_ex05.service;

import com.sduty.spring_boot_ex05.domain.Block;
import com.sduty.spring_boot_ex05.domain.Person;
import com.sduty.spring_boot_ex05.domain.dto.Birthday;
import com.sduty.spring_boot_ex05.repository.BlockRepository;
import com.sduty.spring_boot_ex05.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExculdeBlocks() {
        givenPeople();
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

//        System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName() {
        givenPeople();

        List<Person> result = personService.getPeopleByName("martin");

        result.forEach(System.out::println);
    }

    @Test
    void findByBirthDayBetween() {
        givenPerson("martin", 10, "A", LocalDate.of(1991, 8, 15));
        givenPerson("jhon", 9, "AB", LocalDate.of(1992, 5, 15));
        givenPerson("david", 9, "B", LocalDate.of(1993, 4, 15));
        givenPerson("denis", 10, "A", LocalDate.of(1994, 3, 15));
        givenPerson("sophia", 9, "AB", LocalDate.of(1991, 2, 15));
        givenPerson("benny", 9, "B", LocalDate.of(1991, 8, 15));

        List<Person> result = personRepository.findByBirthday(8,15);

        result.forEach(System.out::println);
    }


    private void givenPeople() {
//        givenPerson("martin", 10, "A");
//        givenPerson("jhon", 9, "AB");
//        givenPerson("david", 9, "B");
        givenBlockPerson("dennis", 11, "O");
        givenBlockPerson("martin", 10, "A");
    }

    private void givenBlocks() {
        givenBlock("martin");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));

    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = Person.builder().name(name).age(age).bloodType(bloodType).build();
        person.setBirthday(new Birthday(birthday.getDayOfYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
        personRepository.save(person);
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = Person.builder().name(name).age(age).bloodType(bloodType).build();
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }
}
