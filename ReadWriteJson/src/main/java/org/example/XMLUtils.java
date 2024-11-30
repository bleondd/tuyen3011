package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {
    // Write data to XML
    public static void writeDataToFileXML(List<Patient> patients, String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("Patients");
        doc.appendChild(root);

        for (Patient p : patients) {
            Element patient = doc.createElement("Patient");

            Element id = doc.createElement("Id");
            id.appendChild(doc.createTextNode(String.valueOf(p.id)));
            patient.appendChild(id);

            Element fullname = doc.createElement("Fullname");
            fullname.appendChild(doc.createTextNode(p.fullname));
            patient.appendChild(fullname);

            Element weight = doc.createElement("Weight");
            weight.appendChild(doc.createTextNode(String.valueOf(p.weight)));
            patient.appendChild(weight);

            Element height = doc.createElement("Height");
            height.appendChild(doc.createTextNode(String.valueOf(p.height)));
            patient.appendChild(height);

            Element bloodType = doc.createElement("BloodType");
            bloodType.appendChild(doc.createTextNode(String.valueOf(p.bloodType)));
            patient.appendChild(bloodType);

            Element gender = doc.createElement("Gender");
            gender.appendChild(doc.createTextNode(p.gender ? "Male" : "Female"));
            patient.appendChild(gender);

            Element birthDate = doc.createElement("BirthDate");
            birthDate.appendChild(doc.createTextNode(p.birthDate.toString()));
            patient.appendChild(birthDate);

            root.appendChild(patient);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);
    }

    // Read data from XML
    public static List<Patient> readDataFromFileXML(String fileName) throws Exception {
        List<Patient> patients = new ArrayList<>();
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Patient");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                int id = Integer.parseInt(eElement.getElementsByTagName("Id").item(0).getTextContent());
                String fullname = eElement.getElementsByTagName("Fullname").item(0).getTextContent();
                int weight = Integer.parseInt(eElement.getElementsByTagName("Weight").item(0).getTextContent());
                float height = Float.parseFloat(eElement.getElementsByTagName("Height").item(0).getTextContent());
                char bloodType = eElement.getElementsByTagName("BloodType").item(0).getTextContent().charAt(0);
                boolean gender = eElement.getElementsByTagName("Gender").item(0).getTextContent().equals("Male");
                LocalDate birthDate = LocalDate.parse(eElement.getElementsByTagName("BirthDate").item(0).getTextContent());

                patients.add(new Patient(id, fullname, weight, height, bloodType, gender, birthDate));
            }
        }
        return patients;
    }
}
