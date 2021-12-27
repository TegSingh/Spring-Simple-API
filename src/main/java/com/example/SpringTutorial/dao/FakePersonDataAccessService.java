package com.example.SpringTutorial.dao;

import com.example.SpringTutorial.model.Person;
import org.springframework.stereotype.Repository;

// FakePersonDataAccessService is a fake database being used in place of more robust DBs like PostgreSQL, etc
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Adding the repository name makes dependency injection simpler
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    // Define the list of persons to act as a fake database
    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return db;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personEx = selectPersonById(id);
        if (personEx.isEmpty()) {
            return 0;
        }
        db.remove(personEx.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(person1 -> {
                    int index = db.indexOf(person1);
                    if (index >= 0) {
                        db.set(index, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
