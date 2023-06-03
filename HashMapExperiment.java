import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HashMapExperiment {
    public static void main(String[] args) {
        // Create a sample bruh map
        Map<String, BigDecimal> bruh = new HashMap<>();
        bruh.put("2023-05-30", new BigDecimal("123.45"));
        bruh.put("2023-05-31", new BigDecimal("127.80"));
        bruh.put("2023-06-01", new BigDecimal("130.25"));
        bruh.put("2023-06-02", new BigDecimal("128.75"));

        // Print the date and close quotes from the bruh map
        for (Map.Entry<String, BigDecimal> entry : bruh.entrySet()) {
            String date = entry.getKey();
            BigDecimal close = entry.getValue();
            System.out.println(date +" "+ close);
        }
    }

}

