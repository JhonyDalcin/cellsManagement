package com.github.jhonydalcin.cellsmanagement.service;

import com.github.jhonydalcin.cellsmanagement.model.Person;
import com.github.jhonydalcin.cellsmanagement.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> personFindAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findById(id)
                .orElseThrow(
                    () -> new EntityNotFoundException("Entity not found.")
                );
    }

    public void deleteById(Long id){
        Person person = personRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not found.")
        );
        personRepository.delete(person);
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Person personToUpdate){
        Person person = this.findById(personToUpdate.getId());

        person.setName(personToUpdate.getName());
        person.setCpf(personToUpdate.getCpf());
        person.setBirthdate(personToUpdate.getBirthdate());
        person.setGender(personToUpdate.getGender());
        person.setMaritalStatus(personToUpdate.getMaritalStatus());
        person.setPhoneNumber(personToUpdate.getPhoneNumber());
        person.setNumberOfChildren(personToUpdate.getNumberOfChildren());
        person.setEmail(personToUpdate.getEmail());

        personRepository.save(person);

        return person;

    }


}
