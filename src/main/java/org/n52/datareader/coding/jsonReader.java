package org.n52.datareader.coding;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.datareader.model.Measurement;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


@Component
//@RestController
public class jsonReader implements DataFormatReader{

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf("application/json").isCompatibleWith(mt);
    }

    @Override
    //@GetMapping( path = "/json-data", produces = "application/json")
    public List<Measurement> readFile(Path p) throws IOException {
        //Converting the Path object into a Folder
        File file = p.toFile();
        ObjectMapper mapper = new ObjectMapper();
        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, Measurement.class);
        List<Measurement> measurements = mapper.readValue(file, listType);
        return measurements;
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, Measurement.class);
        List<Measurement> measurements = mapper.readValue(stream, listType);
        return measurements;
    }

}
