package lr8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFile {
    private static final String FILE_PATH = "src/lr8/animals.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("animals");
            doc.appendChild(rootElement);

            addAnimal(doc, rootElement, "Барсик", "кот", "3", "Алексей");
            addAnimal(doc, rootElement, "Шарик", "собака", "5", "Мария");
            addAnimal(doc, rootElement, "Кеша", "попугай", "2", "Иван");

            saveDocument(doc, FILE_PATH);
            System.out.println("XML-файл со списком домашних животных успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addAnimal(
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

    private static void saveDocument(Document doc, String filePath) throws Exception {
        doc.setXmlStandalone(true);
        doc.normalizeDocument();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }
}
