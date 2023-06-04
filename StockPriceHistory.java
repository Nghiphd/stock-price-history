import yahoofinance.*;
import java.util.Calendar;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes.HistoricalQuote;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

/**
 * Retrieve historical stock prices
 */
public class StockPriceHistory
{

    private final String TICKER = "GOOG";

    /**
     * Retrieve the stock price data
     */
    public void run() {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.MONTH,-1);
        String at = formatDate(from);
        Map<String,BigDecimal> bruh = new HashMap<>();

        try {
            Stock stock = YahooFinance.get(TICKER, true);
            List<HistoricalQuote> googQuote = stock.getHistory(from, to, Interval.DAILY);
            for(HistoricalQuote quote: googQuote) {
                BigDecimal googClose = quote.getClose();
                bruh.put(formatDate(quote.getDate()),googClose);
            }

            for (Map.Entry<String, BigDecimal> entry : bruh.entrySet()) {
                String date = entry.getKey();
                BigDecimal close = entry.getValue();
                System.out.println(date +" "+ close);
            }
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }

    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";

        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }

    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}

