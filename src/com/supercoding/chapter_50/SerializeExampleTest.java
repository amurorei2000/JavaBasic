package com.supercoding.chapter_50;

import java.io.*;

public class SerializeExampleTest {
    public static void main(String[] args) {
        // 직렬화(object -> bytes)
        Person person = new Person("박원석", "Male", 45, "Korea", "Developer");

        byte[] serializeData = null;

        try (ByteArrayOutputStream bao = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(bao)
        ) {
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();

            serializeData = bao.toByteArray();
            System.out.println("직렬화 후: " + new String(serializeData));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 역직렬화(bytes -> object)
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializeData);
            ObjectInputStream objectInputStream = new ObjectInputStream(bis)
        ) {
            Person person2 = (Person)objectInputStream.readObject();
            System.out.println("역직렬화 후: " + person2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
