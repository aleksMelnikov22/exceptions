package impl;

import java.io.FileWriter;
import java.io.IOException;

public class Repository {
    public Repository() {
    }
    public void writeUser(User user) {
        try(FileWriter writer = new FileWriter(user.getSurname()+".txt", true))
        {

            writer.write(user.toString());

            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}