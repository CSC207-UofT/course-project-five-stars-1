package Gateway;

import java.io.*;
import java.util.HashMap;

public class InternReadWriter implements ReadWriter{
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param intern    stores the list of users to be serialized
     */
    @Override
    public void saveToFile(String filePath, Object intern) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Object
        output.writeObject(intern);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     */
    @Override
    public HashMap<String, Integer> readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        HashMap<String, Integer> intern_list = (HashMap<String, Integer>) input.readObject();
        // serialize the Map
        input.close();
        return intern_list;
    }

}
