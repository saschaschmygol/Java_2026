package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XmlParser {
    private static final String FILE_PATH = "src/lr8/animals.xml";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            createFileIfNotExists();

            while (true) {
                System.out.println("\nМеню XML-парсера домашних животных");
                System.out.println("1. Показать всех животных");
                System.out.println("2. Добавить животное");
                System.out.println("3. Найти животных по виду");
                System.out.println("4. Найти животных по возрасту");
                System.out.println("5. Удалить животное по имени");
                System.out.println("0. Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        printAllAnimals();
                        break;
                    case "2":
                        addAnimalFromConsole(scanner);
                        break;
                    case "3":
                        System.out.print("Введите вид животного: ");
                        searchAnimals("type", scanner.nextLine());
                        break;
                    case "4":
                        System.out.print("Введите возраст животного: ");
                        searchAnimals("age", scanner.nextLine());
                        break;
                    case "5":
                        System.out.print("Введите имя животного для удаления: ");
                        deleteAnimal(scanner.nextLine());
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
        File inputFile = new File(FILE_PATH);
        if (inputFile.exists()) {
            return;
        }

        Document doc = createEmptyDocument();
        Element rootElement = doc.createElement("animals");
        doc.appendChild(rootElement);

        appendAnimal(doc, rootElement, "Барсик", "кот", "3", "Алексей");
        appendAnimal(doc, rootElement, "Шарик", "собака", "5", "Мария");
        appendAnimal(doc, rootElement, "Кеша", "попугай", "2", "Иван");

        saveDocument(doc);
    }

    private static void printAllAnimals() throws Exception {
        Document doc = loadDocument();
        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("animal");
        if (nodeList.getLength() == 0) {
            System.out.println("Список животных пуст.");
            return;
        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            printAnimal(nodeList.item(i));
        }
    }

    private static void addAnimalFromConsole(Scanner scanner) throws Exception {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите вид животного: ");
        String type = scanner.nextLine();

        System.out.print("Введите возраст животного: ");
        String age = scanner.nextLine();

        System.out.print("Введите имя владельца: ");
        String owner = scanner.nextLine();

        Document doc = loadDocument();
        Element rootElement = doc.getDocumentElement();
        appendAnimal(doc, rootElement, name, type, age, owner);
        saveDocument(doc);

        System.out.println("Новое животное добавлено в XML-файл.");
    }

    private static void searchAnimals(String tagName, String value) throws Exception {
        Document doc = loadDocument();
        NodeList nodeList = doc.getElementsByTagName("animal");
        boolean found = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element animal = (Element) node;
                String currentValue = getText(animal, tagName);

                if (currentValue.equalsIgnoreCase(value.trim())) {
                    printAnimal(node);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Животные по заданному критерию не найдены.");
        }
    }

    private static void deleteAnimal(String name) throws Exception {
        Document doc = loadDocument();
        NodeList nodeList = doc.getElementsByTagName("animal");
        boolean deleted = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element animal = (Element) node;

                if (getText(animal, "name").equalsIgnoreCase(name.trim())) {
                    animal.getParentNode().removeChild(animal);
                    deleted = true;
                    i--;
                }
            }
        }

        if (deleted) {
            saveDocument(doc);
            System.out.println("Животное удалено из XML-файла.");
        } else {
            System.out.println("Животное с таким именем не найдено.");
        }
    }

    private static Document loadDocument() throws Exception {
        File inputFile = new File(FILE_PATH);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }

    private static Document createEmptyDocument() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.newDocument();
    }

    private static void appendAnimal(
            Document doc,
            Element rootElement,
            String name,
            String type,
            String age,
            String owner
    ) {
        Element animal = doc.createElement("animal");
        rootElement.appendChild(animal);

        appendElement(doc, animal, "name", name);
        appendElement(doc, animal, "type", type);
        appendElement(doc, animal, "age", age);
        appendElement(doc, animal, "owner", owner);
    }

    private static void appendElement(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    private static void printAnimal(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            return;
        }

        Element animal = (Element) node;
        System.out.println("\nТекущий элемент: " + node.getNodeName());
        System.out.println("Имя животного: " + getText(animal, "name"));
        System.out.println("Вид: " + getText(animal, "type"));
        System.out.println("Возраст: " + getText(animal, "age"));
        System.out.println("Владелец: " + getText(animal, "owner"));
    }

    private static String getText(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static void saveDocument(Document doc) throws Exception {
        removeWhitespaceNodes(doc.getDocumentElement());
        doc.setXmlStandalone(true);
        doc.normalizeDocument();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static void removeWhitespaceNodes(Node node) {
        NodeList childNodes = node.getChildNodes();

        for (int i = childNodes.getLength() - 1; i >= 0; i--) {
            Node child = childNodes.item(i);

            if (child.getNodeType() == Node.TEXT_NODE && child.getTextContent().trim().isEmpty()) {
                node.removeChild(child);
            } else if (child.hasChildNodes()) {
                removeWhitespaceNodes(child);
            }
        }
    }
}
