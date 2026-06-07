package lr8;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadExcelFileExample {
    private static final String FILE_PATH = "src/lr8/example3.xlsx";
    private static final String SHEET_NAME = "Товары";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    readExcelFile();
                    System.out.println("Файл Excel успешно прочитан.");
                    return;
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден: " + FILE_PATH);
                    System.out.println("Создайте файл через WriteExcelFileExample или проверьте путь.");
                } catch (NotOfficeXmlFileException | InvalidFormatException e) {
                    System.out.println("Неверный формат файла: " + FILE_PATH);
                    System.out.println("Нужен файл Excel формата .xlsx. Пересохраните файл в правильном формате.");
                } catch (MissingSheetException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Создайте лист с таким именем или измените константу SHEET_NAME в программе.");
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении Excel-файла: " + e.getMessage());
                    System.out.println("Закройте файл в Excel, проверьте права доступа и попробуйте снова.");
                }

                if (!askRetry(scanner)) {
                    System.out.println("Работа программы завершена.");
                    return;
                }
            }
        }
    }

    private static void readExcelFile() throws IOException, InvalidFormatException, MissingSheetException {
        try (
                FileInputStream inputStream = new FileInputStream(FILE_PATH);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream)
        ) {
            XSSFSheet sheet = workbook.getSheet(SHEET_NAME);

            if (sheet == null) {
                throw new MissingSheetException("Лист \"" + SHEET_NAME + "\" не найден в файле " + FILE_PATH + ".");
            }

            DataFormatter formatter = new DataFormatter();

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(formatter.formatCellValue(cell) + "\t");
                }
                System.out.println();
            }
        }
    }

    private static boolean askRetry(Scanner scanner) {
        System.out.print("Исправьте ошибку и повторить чтение файла? (да/нет): ");
        String answer = scanner.nextLine().trim();
        return answer.equalsIgnoreCase("да") || answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }

    private static class MissingSheetException extends Exception {
        public MissingSheetException(String message) {
            super(message);
        }
    }
}
