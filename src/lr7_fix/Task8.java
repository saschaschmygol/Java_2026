package lr7_fix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Task8 {
    public static void main(String[] args) {
        String fileName = "src/lr7_fix/person.dat";
        Person person = new Person("Алексей", 20, "Информатика");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(person);
            System.out.println("Объект записан в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта: " + e.getMessage());
            return;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Person restoredPerson = (Person) inputStream.readObject();

            System.out.println("Объект восстановлен из файла:");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
            System.out.println("Специальность: " + restoredPerson.getSpecialization());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта: " + e.getMessage());
        }
    }

    private static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String name;
        private final int age;
        private final String specialization;

        public Person(String name, int age, String specialization) {
            this.name = name;
            this.age = age;
            this.specialization = specialization;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSpecialization() {
            return specialization;
        }
    }
}
