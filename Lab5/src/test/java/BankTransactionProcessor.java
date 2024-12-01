import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankTransactionProcessor {
    private List<BankTransaction> transactions;

    public BankTransactionProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public double calculateTotalAmount() {
        return transactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public Map<String, Long> transactionsCountByMonth() {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> String.format("%02d-%d", t.getDate().getMonthValue(), t.getDate().getYear()),
                        Collectors.counting()
                ));
    }
    
    
    public List<BankTransaction> topExpenses(int n) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Chỉ lấy giao dịch âm (chi tiêu)
                .sorted(Comparator.comparingDouble(BankTransaction::getAmount).reversed()) // Sắp xếp chi tiêu từ lớn nhất đến nhỏ nhất
                .limit(n)
                .collect(Collectors.toList()); // Trả về danh sách BankTransaction, không phải String
    }
    
    

    public String mostSpentCategory() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Chỉ xét giao dịch chi tiêu
                .collect(Collectors.groupingBy(
                        BankTransaction::getDescription,
                        Collectors.summingDouble(BankTransaction::getAmount)
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()) // Tìm danh mục có tổng chi tiêu lớn nhất
                .get()
                .getKey();
    }
    
}
