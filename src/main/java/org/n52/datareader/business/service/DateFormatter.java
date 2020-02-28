package org.n52.datareader.business.service;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* xml adapter is used in JAXB and to be automatically adjusted
*    @XmlJavaTypeAdapter(DateFormatter.class)
    @JsonProperty(TIME)
    @XmlElement(name = TIME)
    public void setTime(Date time) {
        this.time = time;
    }
*
*  */
public class DateFormatter extends XmlAdapter<String, Date> {

   public static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    @Override
    public String marshal(Date v) {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
    }

    @Override
    public Date unmarshal(String v) throws ParseException {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
    }

}

