package com.sduty.spring_boot_ex05.service;

import com.sduty.spring_boot_ex05.domain.Block;
import com.sduty.spring_boot_ex05.domain.Person;
import com.sduty.spring_boot_ex05.repository.BlockRepository;
import com.sduty.spring_boot_ex05.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();
        List<Block> blocks = blockRepository.findAll();

        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
    }
}
