import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class JSONParser implements TransactionParser {
    @Override
    public List<BankTransaction> parse(String inputFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(inputFile), new TypeReference<List<BankTransaction>>() {});
        } catch (Exception e) {
            throw new Exception("Error parsing JSON file: " + e.getMessage());
        }
    }
}
