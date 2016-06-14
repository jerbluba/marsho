package manager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
public class DateTool {
    private static DateFormat dateFormat = new SimpleDateFormat(
            "yyyy/MM/dd kk:mm:ss");
 
    public static String DateTimeFormat(java.sql.Timestamp time) {
 
        return (dateFormat.format(time));
    }
}