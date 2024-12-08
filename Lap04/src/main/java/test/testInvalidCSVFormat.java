import Utils.CSVTransactionImporter;
import Utils.CustomException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.*;

@Test
public void testInvalidCSVFormat() {
    File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");
    CSVTransactionImporter importer = new CSVTransactionImporter();

    Exception exception = assertThrows(CustomException.class, () -> {
        importer.importTransactions(file);
    });

    assertTrue(exception.getMessage().contains("Invalid CSV format"));
}
public class testinvalidcsvformat {
    public static void main(String[] args) {
        // Viết code ở đây để kiểm tra
        System.out.println("Testing Invalid CSV Format...");
    }
}

public void main() {
    System.out.println("Testing Invalid CSV Format...");
}
