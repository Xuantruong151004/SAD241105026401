import Model.Transaction;
import Utils.CSVTransactionImporter;
import Utils.CustomException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
@Test
public void testTotalTransactionAmountByMonth() throws CustomException {
    File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");
    CSVTransactionImporter importer = new CSVTransactionImporter();
    List<Transaction> transactions = importer.importTransactions(file);

    // Tổng tiền giao dịch tháng 12
    double totalDecember = 0;
    for (Transaction transaction : transactions) {
        if (transaction.getDate().startsWith("2024-12")) {
            totalDecember += transaction.getAmount();
        }
    }

    assertEquals(350.0, totalDecember);  // Kiểm tra tổng tiền tháng 12
}

public void main() {
    System.out.println("Tổng số tiền giao dịch Theo Tháng");
}
