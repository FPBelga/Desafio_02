package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverte {

    public static String convertDateHour(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return format.format(data);
    }

}
