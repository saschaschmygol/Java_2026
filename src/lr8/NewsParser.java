package lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NewsParser {
    private static final String URL = "https://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/lr8/news.txt";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        try {
            Document doc = loadDocumentWithRetries(URL);
            List<String> news = parseNews(doc);

            if (news.isEmpty()) {
                System.out.println("Новости не найдены.");
                return;
            }

            printNews(news);
            saveNews(news);
            System.out.println("Новости сохранены в файл: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("Не удалось получить HTML-код страницы после нескольких попыток.");
            System.out.println("Причина ошибки: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Повторное подключение было прервано.");
        }
    }

    private static Document loadDocumentWithRetries(String url) throws IOException, InterruptedException {
        IOException lastException = null;

        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + " из " + MAX_RETRIES + "...");
                return Jsoup.connect(url)
                        .timeout(10000)
                        .get();
            } catch (IOException e) {
                lastException = e;
                System.out.println("Ошибка при получении HTML-кода страницы: " + e.getMessage());

                if (attempt < MAX_RETRIES) {
                    System.out.println("Повторное подключение через " + (RETRY_DELAY_MS / 1000) + " сек.");
                    Thread.sleep(RETRY_DELAY_MS);
                }
            }
        }

        throw lastException;
    }

    private static List<String> parseNews(Document doc) {
        List<String> news = new ArrayList<>();

        Elements newsParent = doc
                .select("body > table > tbody > tr > td > div > table > " +
                        "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                        "tr > td:nth-child(1)");

        if (newsParent.isEmpty()) {
            return news;
        }

        List<Node> nodes = newsParent.get(0).childNodes();

        for (int i = 3; i < 20 && i < nodes.size(); i++) {
            if (i % 2 == 0 && nodes.get(i) instanceof Element) {
                Element newsElement = (Element) nodes.get(i);
                String title = newsElement.getElementsByClass("blocktitle").text();
                String date = newsElement.getElementsByClass("blockdate").text();

                if (!title.isEmpty() || !date.isEmpty()) {
                    news.add("Тема: " + title);
                    news.add("Дата: " + date);
                    news.add("");
                }
            }
        }

        return news;
    }

    private static void printNews(List<String> news) {
        for (String line : news) {
            System.out.println(line);
        }
    }

    private static void saveNews(List<String> news) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                Files.newOutputStream(Paths.get(OUTPUT_FILE)),
                StandardCharsets.UTF_8
        )) {
            for (String line : news) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        }
    }
}
