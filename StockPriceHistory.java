import yahoofinance.*;
import java.util.Calendar;
import yahoofinance.histquotes.Interval;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Retrieve historical stock prices
 */
public class StockPriceHistory
{

    private final String TICKER = "GOOG";
    Calendar rightNow = Calendar.getInstance();
    Interval interval = Interval.DAILY;
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance(); 
            from.add(Calendar.MONTH, -1); // from 5 years ago
            
            Stock stock = YahooFinance.get(TICKER,Interval.DAILY);
            System.out.println("Date,Closing price");
            System.out.println(formatDate(from));
            System.out.println(stock.getHistory());
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

