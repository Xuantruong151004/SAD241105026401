import Model.Transaction;
import Utils.CSVTransactionImporter;
import Utils.CustomException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

@Test
public void testTotalTransactionAmount() throws CustomException {
    File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");
    CSVTransactionImporter importer = new CSVTransactionImporter();
    List<Transaction> transactions = importer.importTransactions(file);

    double totalAmount = 0;
    for (Transaction transaction : transactions) {
        totalAmount += transaction.getAmount();
    }

    assertEquals(350.0, totalAmount);  // Kiểm tra tổng tiền giao dịch
}



public void main() {
    System.out.println("Kiểm tra lại tiền giao dịch");
}



