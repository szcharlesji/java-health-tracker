package com.project;

import java.io.*;

public class DataStorage {
    public static void saveRecord(Person person) {
        try {
            FileOutputStream f = new FileOutputStream(new File("./data/" + person.getName() + ".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(person);
            o.close();
            f.close();
        } catch (IOException e) {
//            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
    }

    public static Person loadRecord(String name) {
        try {
            FileInputStream fi = new FileInputStream("./data/" + name);
            ObjectInputStream oi = new ObjectInputStream(fi);

            return (Person) oi.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Person[] loadAllFile() {
        File folder = new File("./data/");
        File[] listOfFiles = folder.listFiles();

        int userCounter = 0;

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                userCounter++;
            }
        }

        Person[] userList = new Person[userCounter];

        int i = 0;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                userList[i] = loadRecord(file.getName());
                i++;
            }
        }
        return userList;
    }

    public static void main(String[] args) {
        Person[] userList = loadAllFile();

        for (Person user : userList) {
            System.out.println(user.getName() + "\n");
        }
    }

}
