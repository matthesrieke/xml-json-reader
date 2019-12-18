package org.n52.datareader.coding;

import org.n52.datareader.model.Measurement;
import org.n52.datareader.model.Measurements;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@Component
public class XmlReader implements DataFormatReader {

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf("application/xml").isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException {
        try {
            //Converting the Path object into a Folder so it can be used in jUnmarshaller.unmarshal
            File file = p.toFile();
            // Creating Unmarshaller
            JAXBContext jContext = JAXBContext.newInstance(Measurements.class);
            Unmarshaller jUnmarshaller = jContext.createUnmarshaller();

            Measurements unmarshaledList = (Measurements) jUnmarshaller.unmarshal(new FileReader(file));

            return unmarshaledList.getMeasurements();

        } catch (JAXBException e){
            throw new IOException(e);
        }
    }


    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {

        try {
            // Creating Unmarshaller
            JAXBContext jContext = JAXBContext.newInstance(Measurements.class);
            javax.xml.bind.Unmarshaller jUnmarshaller = jContext.createUnmarshaller();

            Measurements unmarshaledList = (Measurements) jUnmarshaller.unmarshal(stream);

            return unmarshaledList.getMeasurements();

        } catch (JAXBException e){
            throw new IOException(e);
        }
    }
}
