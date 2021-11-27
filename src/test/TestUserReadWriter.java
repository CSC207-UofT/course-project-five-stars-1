import Entity.Employee;
import Entity.User;
import Gateway.UserReadWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserReadWriter {
    static UserReadWriter readWriter = new UserReadWriter();
    static ArrayList<User> users;
    static Employee usr;

    @BeforeAll
    public static void setUp() {
        users = new ArrayList<>();
        usr = new Employee("hello", "hola", "222", "hello@gmail.com", "food");
        users.add(usr);
    }

    @Test
    public void testSaveToFile() throws IOException, ClassNotFoundException {
        readWriter.saveToFile("user.test", users);

        OutputStream file = new FileOutputStream("user.test2");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(users);
        output.close();

        ArrayList<User> actual = readWriter.readFromFile("user.test");
        ArrayList<User> expected = readWriter.readFromFile("user.test2");

        for (int i = 0; i < actual.size(); i++){
            assertEquals(actual.get(i).toString(), expected.get(i).toString());
        }
    }

    @Test
    public void testReadFromFile() throws ClassNotFoundException, IOException {
        ArrayList<User> actual = readWriter.readFromFile("user.test");
        String expected = "[Employee {Username = hello, Salary = 0, Attendance = " +
                "false, ID = 222, Email = hello@gmail.com, Major = food}]";

        assertEquals(expected, actual.toString());

    }
}
