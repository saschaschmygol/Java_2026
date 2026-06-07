package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParser {
    private static final String FILE_PATH = "src/lr8/animals-json.json";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            createFileIfNotExists();

            while (true) {
                System.out.println("\nМеню JSON-парсера домашних животных");
                System.out.println("1. Показать всех животных");
                System.out.println("2. Найти животных по виду");
                System.out.println("3. Добавить животное");
                System.out.println("4. Удалить животное по имени");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        printAllAnimals();
                        break;
                    case "2":
                        System.out.print("Введите вид животного: ");
                        searchAnimalsByType(scanner.nextLine());
                        break;
                    case "3":
                        addAnimalFromConsole(scanner);
                        break;
                    case "4":
                        System.out.print("Введите имя животного для удаления: ");
                        deleteAnimalByName(scanner.nextLine());
                        break;
                    case "0":
                        System.out.println("Работа программы завершена.");
                        return;
                    default:
                        System.out.println("Такого пункта меню нет.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFileIfNotExists() throws Exception {
        if (Files.exists(Paths.get(FILE_PATH))) {
            return;
        }

        JSONObject jsonObject = new JSONObject();
        JSONArray animals = new JSONArray();
        animals.add(createAnimal("Барсик", "кот", 3, "Алексей"));
        animals.add(createAnimal("Шарик", "собака", 5, "Мария"));
        animals.add(createAnimal("Кеша", "попугай", 2, "Иван"));
        jsonObject.put("animals", animals);
        saveJsonObject(jsonObject);
    }

    private static void printAllAnimals() throws Exception {
        JSONObject jsonObject = loadJsonObject();
        System.out.println("Корневой элемент: animals");

        JSONArray jsonArray = (JSONArray) jsonObject.get("animals");
        if (jsonArray.isEmpty()) {
            System.out.println("Список животных пуст.");
            return;
        }

        for (Object o : jsonArray) {
            if (o instanceof JSONObject) {
                printAnimal((JSONObject) o);
            }
        }
    }

    private static void searchAnimalsByType(String type) throws Exception {
        JSONObject jsonObject = loadJsonObject();
        JSONArray jsonArray = (JSONArray) jsonObject.get("animals");
        final boolean[] found = {false};

        jsonArray.stream()
                .filter(animal -> animal instanceof JSONObject)
                .filter(animal -> {
                    JSONObject jsonAnimal = (JSONObject) animal;
                    return type.trim().equalsIgnoreCase(String.valueOf(jsonAnimal.get("type")));
                })
                .forEach(animal -> {
                    printAnimal((JSONObject) animal);
                    found[0] = true;
                });

        if (!found[0]) {
            System.out.println("Животные указанного вида не найдены.");
        }
    }

    private static void addAnimalFromConsole(Scanner scanner) throws Exception {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите вид животного: ");
        String type = scanner.nextLine();

        System.out.print("Введите возраст животного: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите имя владельца: ");
        String owner = scanner.nextLine();

        JSONObject jsonObject = loadJsonObject();
        JSONArray jsonArray = (JSONArray) jsonObject.get("animals");
        jsonArray.add(createAnimal(name, type, age, owner));
        saveJsonObject(jsonObject);

        System.out.println("Новое животное добавлено в JSON-файл.");
    }

    private static void deleteAnimalByName(String name) throws Exception {
        JSONObject jsonObject = loadJsonObject();
        JSONArray jsonArray = (JSONArray) jsonObject.get("animals");
        Iterator iterator = jsonArray.iterator();
        boolean deleted = false;

        while (iterator.hasNext()) {
            Object item = iterator.next();

            if (item instanceof JSONObject) {
                JSONObject animal = (JSONObject) item;

                if (name.trim().equalsIgnoreCase(String.valueOf(animal.get("name")))) {
                    iterator.remove();
                    deleted = true;
                }
            }
        }

        if (deleted) {
            saveJsonObject(jsonObject);
            System.out.println("Животное удалено из JSON-файла.");
        } else {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    private static JSONObject loadJsonObject() throws Exception {
        JSONParser parser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(
                Files.newInputStream(Paths.get(FILE_PATH)),
                StandardCharsets.UTF_8
        )) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static void saveJsonObject(JSONObject jsonObject) throws Exception {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                Files.newOutputStream(Paths.get(FILE_PATH)),
                StandardCharsets.UTF_8
        )) {
            writer.write(jsonObject.toJSONString());
        }
    }

    private static JSONObject createAnimal(String name, String type, int age, String owner) {
        JSONObject animal = new JSONObject();
        animal.put("name", name);
        animal.put("type", type);
        animal.put("age", age);
        animal.put("owner", owner);
        return animal;
    }

    private static void printAnimal(JSONObject animal) {
        System.out.println("\nТекущий элемент: animal");
        System.out.println("Имя животного: " + animal.get("name"));
        System.out.println("Вид: " + animal.get("type"));
        System.out.println("Возраст: " + animal.get("age"));
        System.out.println("Владелец: " + animal.get("owner"));
    }
}
