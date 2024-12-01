import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionSearcher {
    public List<BankTransaction> searchByDescription(List<BankTransaction> transactions, String description) {
        return transactions.stream()
                .filter(transaction -> transaction.getDescription().equalsIgnoreCase(description))
                .collect(Collectors.toList());
    }

    public List<BankTransaction> searchByDate(List<BankTransaction> transactions, LocalDate date) {
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList());
    }

    // public List<BankTransaction> searchTransactions(Predicate<BankTransaction> condition) {
    //     return transactions.stream()
    //             .filter(condition)
    //             .collect(Collectors.toList());
    // }
    
}
