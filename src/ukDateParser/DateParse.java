package ukDateParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDate(String dateString) throws ParseException {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            throw new ParseException("Error parsing date: " + dateString, e.getErrorOffset());
        }
    }
}
