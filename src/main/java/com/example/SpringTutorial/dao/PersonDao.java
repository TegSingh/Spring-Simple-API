package com.example.SpringTutorial.dao;

import com.example.SpringTutorial.model.Person;

import java.util.UUID;

// This interface defines a contract on what methods can be added on the person model. Adding this interface helps switch between implementation with less lines of code
public interface PersonDao {

    // This is the insert method used in case the ID is explicitly specified
    int insertPerson(UUID id, Person person);

    // A method set to default should have an ID - Set our unique UUID through this
    default int addPerson(Person person) {
        // This method is called by default and generates a random ID
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
