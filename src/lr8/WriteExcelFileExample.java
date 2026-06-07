package lr8;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFileExample {
    private static final String FILE_PATH = "src/lr8/example3.xlsx";
    private static final String SHEET_NAME = "Товары";

    public static void main(String[] args) {
        try {
            writeExcelFile();
            System.out.println("Данные записаны в файл: " + FILE_PATH);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось создать или перезаписать файл: " + FILE_PATH);
            System.out.println("Возможная причина: файл открыт в Excel или нет доступа к папке.");
            System.out.println("Закройте файл, проверьте права доступа и запустите программу снова.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи Excel-файла: " + e.getMessage());
            System.out.println("Проверьте путь к файлу и наличие свободного места на диске.");
        }
    }

    private static void writeExcelFile() throws IOException {
        try (
                XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream outputStream = new FileOutputStream(FILE_PATH)
        ) {
            XSSFSheet sheet = workbook.createSheet(SHEET_NAME);

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Товар");
            headerRow.createCell(1).setCellValue("Характеристики");
            headerRow.createCell(2).setCellValue("Стоимость");

            Row dataRow1 = sheet.createRow(1);
            dataRow1.createCell(0).setCellValue("Книга");
            dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
            dataRow1.createCell(2).setCellValue(500.0);

            Row dataRow2 = sheet.createRow(2);
            dataRow2.createCell(0).setCellValue("Компьютер");
            dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память: 8GB");
            dataRow2.createCell(2).setCellValue(25000.0);

            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);
        }
    }
}
