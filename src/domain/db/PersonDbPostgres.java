package domain.db;

import domain.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDbPostgres implements PersonDb {
    private Properties properties;
    private String url; // = "jdbc:postgresql://databanken.ucll.be:61819/2TX38";

    public PersonDbPostgres(Properties properties) {
        this.properties = properties;
        this.url = properties.getProperty("url");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Person get(int id) {
        String sql = "SELECT * from testing.persons where id=" + id;
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);
            Person person = new Person();
            while (result.next()){
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setAdres(result.getString("adres"));
                person.setPostalCode(result.getString("postalcode"));
            }
            return person;
        }catch (SQLException e) {
            throw new DbException(e);
        }
    }
    @Override
    public List<Person> getAll() {
        List<Person> personen = new ArrayList<Person>();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM testing.persons");
            while (result.next()){
                int personid = result.getInt("id");
                String name = result.getString("name");
                String adres = result.getString("adres");
                String postcalCode = result.getString("postcal_code");
                Person person = new Person(personid, name, adres, postcalCode);
                personen.add(person);
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return personen;
    }

    @Override
    public void add(Person person){
        if(person == null){
            throw new DbException("Nothing to add");
        }
        String sql = "INSERT INTO testing.persons (id, name, description, price) VALUES(?,?,?,?);";
        //String sql = "INSERT INTO r0712411web.persons VALUES(" + person.getPersonId() + ",'" + person.getName() + "','" + person.getDescription() +"'," + person.getPrice() +")";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()){
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getAdres());
            statement.setString(4, person.getPostcalCode());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void update(Person person) {
        if (person == null){
            throw new DbException("No person to update");
        }
        int personid = person.getId();
        //String sql = "UPDATE r0712411.persons SET name= '" + person.getName() + ", description = \"" +person.getDescription() +"\", price= " + person.getPrice() + " WHERE personid=" + personid;
        String sql = "UPDATE testing.persons SET name= ?, adres = ?, postal_code= ? WHERE id=?;";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()) {
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, person.getName());
            statement.setString(2, person.getAdres());
            statement.setString(3, person.getPostcalCode());
            statement.setInt(4, person.getId());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM testing.persons WHERE id = ?;";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()) {
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public int getNumberOfPersons() {
        return getAll().size();
    }
}
