package Gateway;

import Controller.UserSystemController;
import Entity.User;
import UseCase.UserManager;

import java.io.*;
import java.util.ArrayList;

public class UserReadWriter implements ReadWriter {

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param users    stores the list of users to be serialized
     */
    @Override
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Object
        output.writeObject(users);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     */
    @Override
    public UserManager readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        Object user_list = input.readObject();
        // serialize the Map

        ArrayList<User> users = (ArrayList) user_list;
        UserManager userManager = new UserManager(users);
        input.close();
        return userManager;
    }
}