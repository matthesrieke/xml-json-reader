package org.n52.datareader.coding;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.domain.Measurements;
import org.n52.datareader.business.service.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@Component
public class JsonReader implements DataFormatReader {

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf(MediaType.APPLICATION_JSON_VALUE).isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException {
        return readJson(p);
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        return readJson(stream);
    }

    private List<Measurement> readJson(Object o) throws IOException {
        JsonParser jsonParser = new JsonParser();
        jsonParser.readJson(o);
        Measurements measurements = jsonParser.getContent();
        return measurements.getMeasurements();
    }

}
