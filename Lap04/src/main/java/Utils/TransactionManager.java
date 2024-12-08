package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Model.Transaction;

public class TransactionManager {
    private final List<Transaction> transactions = new ArrayList<>();

    // Thêm giao dịch
    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        transactions.add(transaction);
        System.out.println("Transaction added: " + transaction.getDescription());
    }

    // Tìm kiếm giao dịch theo tiêu chí
    public List<Transaction> searchTransactions(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Search keyword cannot be null or empty.");
        }
        return transactions.stream()
                .filter(t -> t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Nhập dữ liệu từ Importer
    public void importData(TransactionImporter importer, File file) throws CustomException {
        if (importer == null || file == null) {
            throw new IllegalArgumentException("Importer and file cannot be null.");
        }
        try {
            List<Transaction> importedTransactions = importer.importTransactions(file);
            transactions.addAll(importedTransactions);
            System.out.println("Imported " + importedTransactions.size() + " transactions from file: " + file.getName());
        } catch (Exception e) {
            throw new CustomException("Error importing data from file: " + file.getName(), e);
        }
    }

    // Xuất dữ liệu với Exporter
    public String exportData(TransactionExporter exporter) throws CustomException {
        if (exporter == null) {
            throw new IllegalArgumentException("Exporter cannot be null.");
        }
        return exporter.exportTransactions(transactions);
    }
}
