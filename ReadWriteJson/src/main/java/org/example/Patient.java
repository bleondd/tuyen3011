package org.example;

import java.time.LocalDate;

public class Patient {
    public int id;
    public String fullname;
    public int weight;
    public float height;
    public char bloodType;
    public boolean gender;
    public LocalDate birthDate;

    // Constructor
    public Patient(int id, String fullname, int weight, float height, char bloodType, boolean gender, LocalDate birthDate) {
        this.id = id;
        this.fullname = fullname;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return fullname + " (ID: " + id + ")";
    }
}
