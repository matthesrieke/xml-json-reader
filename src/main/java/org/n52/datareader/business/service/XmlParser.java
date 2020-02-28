package org.n52.datareader.business.service;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.domain.Measurements;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

public class XmlParser {

    public List<Measurement> unmarshall(InputStream in) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Measurements.class);
        Measurements measurements = (Measurements) context.createUnmarshaller().unmarshal(in);
        return measurements.getMeasurements();
    }
}