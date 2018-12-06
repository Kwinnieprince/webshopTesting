package domain.db;

import domain.model.Person;

import java.util.List;

public class PersonDbInMemory implements PersonDb {
    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public void add(Person product) {

    }

    @Override
    public void update(Person product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int getNumberOfPersons() {
        return 0;
    }
}
