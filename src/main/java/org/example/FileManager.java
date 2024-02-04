package org.example;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void writeData(List<Family> families) {
        try (FileOutputStream fileOut = new FileOutputStream("src/main/java/org/example/Data/data.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(families);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Family> loadTestData() {
        List<Family> families;
        try (FileInputStream fileIn = new FileInputStream("src/main/java/org/example/Data/test.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            families = (List<Family>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return families;
    }


    public static List<Family> loadData() {
        List<Family> families;
        try (FileInputStream fileIn = new FileInputStream("src/main/java/org/example/Data/data.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            families = (List<Family>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return families;
    }
}
