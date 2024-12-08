package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.List;
import Utils.CSVTransactionImporter;
import Model.Transaction;
import Utils.CustomException;

public class CSVTransactionImporterTest {

    @Test
    public void testImportTransactions() throws CustomException {
        File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");
        CSVTransactionImporter importer = new CSVTransactionImporter();
        List<Transaction> transactions = importer.importTransactions(file);

        assertNotNull(transactions);
        assertEquals(4, transactions.size());  // Kiểm tra số lượng giao dịch
    }

    @Test
    public void testTransactionDetails() throws CustomException {
        File file = new File("D:/.net/BankStatementAnalyzer/Lap04/src/transactions.csv");
        CSVTransactionImporter importer = new CSVTransactionImporter();
        List<Transaction> transactions = importer.importTransactions(getFile(file));

        // Kiểm tra chi tiết của một giao dịch cụ thể
        Transaction transaction = transactions.get(0);
        assertEquals("2024-12-01", transaction.getDate());
        assertEquals("Payment to Vendor A", transaction.getDescription());
        assertEquals(-100.0, transaction.getAmount());
        assertEquals("Expense", transaction.getType());
    }

    private static File getFile(File file) {
        return file;
    }
}
