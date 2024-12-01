import java.util.List;

public interface TransactionParser {
    List<BankTransaction> parse(String input) throws Exception;
}
