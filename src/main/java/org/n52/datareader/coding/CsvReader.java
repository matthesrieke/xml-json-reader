/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.coding;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import org.n52.datareader.model.Measurement;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

/**
 *
 * @author matthes rieke
 */
@Component
public class CsvReader implements DataFormatReader {

    @Override
    public boolean supportsDataFormat(MimeType mt) {
        return MimeType.valueOf("text/csv").isCompatibleWith(mt);
    }

    @Override
    public List<Measurement> readFile(Path p) throws IOException {
        return Collections.emptyList();
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        return Collections.emptyList();
    }
    
}
