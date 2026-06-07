package lr8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonCreator {
    private static final String FILE_PATH = "src/lr8/animals-json.json";

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray animals = new JSONArray();

        animals.add(createAnimal("Барсик", "кот", 3, "Алексей"));
        animals.add(createAnimal("Шарик", "собака", 5, "Мария"));
        animals.add(createAnimal("Кеша", "попугай", 2, "Иван"));

        jsonObject.put("animals", animals);

        try (OutputStreamWriter writer = new OutputStreamWriter(
                Files.newOutputStream(Paths.get(FILE_PATH)),
                StandardCharsets.UTF_8
        )) {
            writer.write(jsonObject.toJSONString());
            System.out.println("JSON-файл со списком домашних животных успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
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
}
