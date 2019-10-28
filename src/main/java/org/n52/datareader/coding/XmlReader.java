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
import java.util.Collections;
import java.util.List;

@Component
public class XmlReader implements DataFormatReader {

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf("application/xml").isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException, JAXBException {
            File file = p.toFile();
            JAXBContext jContext = JAXBContext.newInstance(Measurements.class);
            Unmarshaller jUnmarshaller = jContext.createUnmarshaller();

            Measurements unmarshaledList = (Measurements) jUnmarshaller.unmarshal(new FileReader(file));

            return unmarshaledList.getMeasurements();


    }


    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        return Collections.emptyList();
    }
}
