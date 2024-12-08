import Model.Transaction;
import Utils.CSVTransactionImporter;
import Utils.CustomException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
@Test
public void testTotalTransactionAmountByType() throws CustomException {
    File file = new File("D:/.net/BankStastementAnalyzerLap04/src/transactions.csv");    CSVTransactionImporter importer = new CSVTransactionImporter();
    List<Transaction> transactions = importer.importTransactions(file);

    double totalIncome = 0;
    double totalExpense = 0;
    for (Transaction transaction : transactions) {
        if (transaction.getType().equals("Income")) {
            totalIncome += transaction.getAmount();
        } else if (transaction.getType().equals("Expense")) {
            totalExpense += transaction.getAmount();
        }
    }

    assertEquals(500.0, totalIncome);  // Kiểm tra tổng tiền Income
    assertEquals(-150.0, totalExpense);  // Kiểm tra tổng tiền Expense
}

public void main() {
    System.out.println("Tổng số tiền giao dịch Theo loại");
}


