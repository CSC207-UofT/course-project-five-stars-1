package Gateway;

import java.io.IOException;
import java.util.HashMap;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     * @return
     */
     Object readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
