package com.project;

import java.io.*;

public class DataStorage {
    public static void saveRecord(Person person) {
        try {
            FileOutputStream f = new FileOutputStream(new File(person.getName() + ".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(person);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static Person loadRecord(String name) {
        try {
            FileInputStream fi = new FileInputStream(new File(name + ".txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            return (Person) oi.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
