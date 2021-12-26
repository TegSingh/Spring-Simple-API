package com.example.SpringTutorial.dao;

import com.example.SpringTutorial.model.Person;
import jdk.jshell.PersistentSnippet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePersonDataAccessService implements PersonDao {

    // Define the list of persons to act as data
    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }
}
