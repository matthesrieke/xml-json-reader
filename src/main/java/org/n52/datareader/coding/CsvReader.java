/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.datareader.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        //Creating a measurement list
        List<Measurement> list = new ArrayList<>();
        // A boolean for skipping the first line
        boolean skipFirstLine = true;
        // Defining a date format corresponding to the date format provided in the data description
        DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        // Using try-with-resources to avid code leaking
        try(BufferedReader reader = Files.newBufferedReader(p);){
            String line;
            while((line = reader.readLine()) != null) {
                if (skipFirstLine) {        // Skipping the first line
                    skipFirstLine = false;
                } else {

                    String[] values = line.split(";", -1);
                    //Initialising the measurements
                    Measurement ms = new Measurement(
                            Double.valueOf(values[1]),
                            format.parse(values[0]),
                            values[2]
                    );
                    list.add(ms);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Measurement> readStream(InputStream stream) throws IOException {
        //Creating a measurement list
        List<Measurement> list = new ArrayList<>();
        // A boolean for skipping the first line
        boolean skipFirstLine = true;
        // Defining a date format corresponding to the date format provided in the data description
        DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        // Using try-with-resources to avid code leaking
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream));){
            String line;
            while((line = reader.readLine()) != null) {
                if (skipFirstLine) {        // Skipping the first line
                    skipFirstLine = false;
                } else {

                    String[] values = line.split(";", -1);
                    Measurement ms = new Measurement(
                            Double.valueOf(values[1]),
                            format.parse(values[0]),
                            values[2]
                    );
                    list.add(ms);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}