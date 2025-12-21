package com.example.modul7;

import javafx.collections.ObservableList;

public interface MedicalService {
    ObservableList<MedicalRecord> getAll();
    void addData(MedicalRecord data);
    void updateData(MedicalRecord oldData, MedicalRecord newData);
    void deleteData(MedicalRecord data);
}
