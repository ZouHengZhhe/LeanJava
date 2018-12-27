package com.zhhe.learnjpa.controller;

import com.zhhe.learnjpa.domain.Person;
import com.zhhe.learnjpa.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-12-12 15:52
 */
@RestController
@RequestMapping("person")
public class PersonController
{
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("getPerson")
    public String getPerson()
    {
        List<Person> list = personRepository.findAll();
        for (Person person:list)
        {
            System.out.println(person.toString());
        }
        return "success";
    }

    @RequestMapping(value = "addPerson",method = RequestMethod.POST)
    @ResponseBody
    public String addPerson(Person person)
    {
        personRepository.save(person);
        return person.toString();
    }

    @RequestMapping("delPerson")
    public void deletePerson(Person person)
    {
        personRepository.delete(person);
    }
}
