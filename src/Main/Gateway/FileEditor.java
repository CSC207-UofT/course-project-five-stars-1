package Gateway;

import java.io.*;
import java.util.ArrayList;

public class FileEditor {

    public void saveUser(ArrayList userList){
        try{
            FileOutputStream fos = new FileOutputStream("UserData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList readUser(){

        ArrayList userList = new ArrayList<>();

        try{
            File file = new File("Userdata");
            file.createNewFile(); // create the file if the file path exists no file
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();

        } catch (EOFException e) {
            userList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return userList;
    }
}