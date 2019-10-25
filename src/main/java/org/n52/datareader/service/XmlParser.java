package org.n52.datareader.service;

import org.n52.datareader.model.Measurements;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;


public class XmlParser {


    private Measurements measurements;

    public void unmarshall(Object in) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Measurements.class);
        if (in instanceof File)
            measurements = (Measurements) context.createUnmarshaller().unmarshal(new FileReader((File) in));
        else if (in instanceof InputStream)
            measurements = (Measurements) context.createUnmarshaller().unmarshal((InputStream) in);
    }

    public Measurements getContent() {
        return measurements;
    }

}