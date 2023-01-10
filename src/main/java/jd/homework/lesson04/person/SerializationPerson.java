package jd.homework.lesson04.person;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class SerializationPerson {

    public static void serializeListOfPersons(Path path, List<Person> listOfPersons) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            for (int i = 0; i < listOfPersons.size(); i++) {
                Person person = listOfPersons.get(i);
                objectOutputStream.writeObject(person);
            }
//            for (Person person : listOfPersons) {
//                objectOutputStream.writeObject(person);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeListOfPersons(Path path, List<Person> listOfPersons) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object object;
            while ((object = objectInputStream.readObject()) != null) {
                listOfPersons.add((Person) object);
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void deserializeListOfPersonsWithStream (Path path, List<Person> listOfPersons) {
//        try (Stream<String> stream = Files.lines(path)) {
//            listOfPersons = stream.collect(Collectors.toCollection(ArrayList<Person>::new));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }






}
