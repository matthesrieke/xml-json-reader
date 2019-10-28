/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.coding;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import org.n52.datareader.model.Measurement;
import org.springframework.util.MimeType;

import javax.xml.bind.JAXBException;

/**
 * This interface provides method for decoding (~= reading) a specific
 * data format to create Measurement objects from the data.
 * 
 * An implementation must read a specific data source (e.g. a file)
 * and create a List of Measurement containing the corresponding data.
 * 
 * @see Measurement
 * @author matthes rieke
 */
public interface DataFormatReader {
    
    boolean supportsDataFormat(MimeType mt);
    
    List<Measurement> readFile(Path p) throws IOException, JAXBException;
    
    List<Measurement> readStream(InputStream stream) throws IOException;
    
}
