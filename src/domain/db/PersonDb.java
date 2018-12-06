package domain.db;

import domain.model.Person;
import java.util.List;

public interface PersonDb {
    Person get(int id);

    List<Person> getAll();

    void add(Person product);

    void update(Person product);

    void delete(int id);

    int getNumberOfPersons();
}
