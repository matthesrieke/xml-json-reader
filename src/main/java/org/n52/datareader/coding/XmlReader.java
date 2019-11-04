package org.n52.datareader.coding;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.XmlParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@Component
public class XmlReader implements DataFormatReader {
    private XmlParser parser = new XmlParser();
    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf(MediaType.APPLICATION_XML_VALUE).isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException {
        try {
            parser.unmarshall(p);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return parser.getContent().getMeasurements();
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        try {
            parser.unmarshall(stream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return parser.getContent().getMeasurements();
    }



}
