package SerializationTasks;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Person person = new Person("Michael", 25, "Teacher");

        FileOutputStream fileOutputStream = new FileOutputStream("E:\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person);
        objectOutputStream.close();*/

        FileInputStream fileInputStream = new FileInputStream("E:\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person deserializedPerson = (Person) objectInputStream.readObject();

        System.out.println(deserializedPerson);
    }
}
