package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtils {
    // Write data to JSON
    public static void writeDataToFileJSON(List<Patient> patients, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), patients);
    }

    // Read data from JSON
    public static List<Patient> readDataFromFileJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(fileName), Patient[].class));
    }
}
