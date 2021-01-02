package com.sduty.spring_boot_ex05.service;

import com.sduty.spring_boot_ex05.domain.Block;
import com.sduty.spring_boot_ex05.domain.Person;
import com.sduty.spring_boot_ex05.repository.BlockRepository;
import com.sduty.spring_boot_ex05.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("jhon", 9, "AB");
        givenPerson("david", 9, "B");
        givenBlockPerson("dennis", 11, "O");
        givenBlockPerson("martin", 10, "A");
    }

    private void givenBlocks() {
        givenBlock("martin");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));

    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }
}
