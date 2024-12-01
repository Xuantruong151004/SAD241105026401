import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements TransactionParser {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<BankTransaction> parse(String inputFile) throws Exception {
        List<BankTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 3) {
                    throw new IllegalArgumentException("Invalid CSV format. Each line must have 3 fields.");
                }
                LocalDate date = LocalDate.parse(fields[0], DATE_FORMAT);
                double amount = Double.parseDouble(fields[1]);
                String category = fields[2];
                transactions.add(new BankTransaction(date, amount, category));
            }
        } catch (IOException e) {
            throw new IOException("Error reading the CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount format in CSV: " + e.getMessage());
        }
        return transactions;
    }
}
