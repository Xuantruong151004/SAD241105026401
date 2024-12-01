import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XMLParser implements TransactionParser {
    @Override
    public List<BankTransaction> parse(String inputFile) throws Exception {
        try {
            JAXBContext context = JAXBContext.newInstance(TransactionListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            TransactionListWrapper wrapper = (TransactionListWrapper) unmarshaller.unmarshal(new File(inputFile));
            return wrapper.getTransactions();
        } catch (Exception e) {
            throw new Exception("Error parsing XML file: " + e.getMessage());
        }
    }
}