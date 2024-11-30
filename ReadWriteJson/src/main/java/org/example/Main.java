package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Input data
            List<Patient> patients = Hospital.inputData();

            // Export to XML
            XMLUtils.writeDataToFileXML(patients, "patients.xml");

            // Export to JSON
            JSONUtils.writeDataToFileJSON(patients, "patients.json");

            // Import from XML and display
            List<Patient> patientsFromXML = XMLUtils.readDataFromFileXML("patients.xml");
            System.out.println("Data from XML:");
            for (Patient p : patientsFromXML) {
                System.out.println(p);
            }

            // Import from JSON and display
            List<Patient> patientsFromJSON = JSONUtils.readDataFromFileJSON("patients.json");
            System.out.println("\nData from JSON:");
            for (Patient p : patientsFromJSON) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
