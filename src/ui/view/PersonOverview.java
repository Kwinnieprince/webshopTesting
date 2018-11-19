package ui.view;

import java.sql.*;
import java.util.Properties;
import domain.model.*;

import javax.swing.*;


public class PersonOverview {
	public static void main(String[] args) throws SQLException {
		Properties properties = new Properties();
		String url = "jdbc:postgresql://databanken.ucll.be:61819/2TX38";
		properties.setProperty("user", "local_r0712411");
		properties.setProperty("password", "ç=Z!3o;J5andq");
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		properties.setProperty("sslmode","prefer");

		String id = JOptionPane.showInputDialog(null, "what is the id of the person?");
		String mail = JOptionPane.showInputDialog(null, "what is the email of the person?");
		String passw = JOptionPane.showInputDialog(null, "what is the password  of the person?");
		String first = JOptionPane.showInputDialog(null, "what is the first name of the person?");
		String last = JOptionPane.showInputDialog(null, "what is the last name of the person?");

		
		Connection connection = DriverManager.getConnection(url,properties);
		String sql = "INSERT INTO r0712411web.persons (userid, email, pass, firstname, lastname) VALUES (?,?,?,?,?);";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);
		statement.setString(2, mail);
		statement.setString(3, passw);
		statement.setString(4, first);
		statement.setString(5, last);
		//Statement statement = connection.createStatement();
		statement.execute();

		ResultSet result = statement.executeQuery( "SELECT * FROM r0712411web.persons" );

		while(result.next()){
			String userid = result.getString("userid");
			String email = result.getString("email");
			String password = result.getString("pass");
			String firstName = result.getString("firstname");
			String lastName = result.getString("lastname");
			try {	// validation of data stored in database
				Person person= new Person();
				person.setUserid(userid);
				person.setEmail(email);
				person.setPassword(password);
				person.setFirstName(firstName);
				person.setLastName(lastName);
				System.out.println(person.toString());
			}
			catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		statement.close();
		connection.close();
	}
}
