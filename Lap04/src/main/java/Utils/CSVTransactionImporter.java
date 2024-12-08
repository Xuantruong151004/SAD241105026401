package Utils;

import Model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVTransactionImporter implements TransactionImporter {

    @Override
    public List<Transaction> importTransactions(File file) throws CustomException {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine(); // Đọc tiêu đề
            if (line == null || !line.trim().equals("Description,Amount,Date,Type")) {
                throw new CustomException("Invalid CSV format. Expected header: Description,Amount,Date,Type",null);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new CustomException("Invalid CSV data row: " + line, null);
                }
                try {
                    String description = parts[0].trim();
                    double amount = Double.parseDouble(parts[1].trim());
                    String date = parts[2].trim(); // Date có thể cần kiểm tra format
                    String type = parts[0].trim();
                    var add = transactions.add(new Transaction(description, amount, date, type));
                } catch (NumberFormatException e) {
                    throw new CustomException("Invalid numeric value in row: " + line, e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new CustomException("File not found: " + file.getName(), e);
        } catch (IOException e) {
            throw new CustomException("Error reading CSV file.", e);
        }
        return transactions;
    }
}
