package org.n52.datareader.coding;

import org.n52.datareader.model.Measurements;
import org.n52.datareader.model.Measurement;
import org.n52.datareader.service.XmlParser;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
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
    public List<Measurement> readFile(Path p) throws IOException {
    return read(p);
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        return read(stream);
    }


    private List<Measurement> read(Object o) throws IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XmlParser xmlParser = new XmlParser();
        SAXParser saxParser =parse(o, factory, xmlParser);
        Measurements measurements =  xmlParser.getContent();

        if (measurements != null) {
            return measurements.getMeasurements();
        }
        return Collections.emptyList();
    }

    private SAXParser parse(Object o, SAXParserFactory factory, XmlParser xmlParser) throws IOException {
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
            if (o instanceof Path)
                saxParser.parse(((Path)o).toFile(), xmlParser);
            else if (o instanceof InputStream)
                saxParser.parse((InputStream) o, xmlParser);
            else throw new IOException("the given object is neither path  nor InputSteam Instance");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return saxParser;
    }
}
