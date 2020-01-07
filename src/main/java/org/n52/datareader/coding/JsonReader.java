package org.n52.datareader.coding;

import org.n52.datareader.business.domain.Measurement;
import org.n52.datareader.business.service.JsonParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
        JsonParser jsonParser = new JsonParser();
        return jsonParser.readJson(Files.newInputStream(p));
    }

}
