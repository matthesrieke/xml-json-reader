package org.n52.datareader.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static Date formatDate (String dateString) {
        Date date = null;
        try {
         date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
       }
    public static String format (Date date) {
        return  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(date) ;
    }

}

