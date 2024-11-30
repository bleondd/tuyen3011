package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    // Input data method for creating patients list
    public static List<Patient> inputData() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "nguyen xuan tuyen", 60, 1.65f, 'A', true, LocalDate.of(2002, 9, 8)));
        patients.add(new Patient(2, "tuyen day ne", 70, 1.75f, 'O', false, LocalDate.of(2000, 5, 15)));
        return patients;
    }
}

