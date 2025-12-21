package com.example.modul7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InMemoryRepository implements MedicalService {

    private ObservableList<MedicalRecord> dataList;

    public InMemoryRepository() {
        dataList = FXCollections.observableArrayList();
        dataList.add(new MedicalRecord("RM-001", "Budi Santoso", "Pusing", "Hipertensi", "Amlodipine 5mg", "2023-10-01"));
        dataList.add(new MedicalRecord("RM-002", "Siti Aminah", "Batuk", "ISPA", "Antibiotik", "2023-10-02"));
    }

    @Override
    public ObservableList<MedicalRecord> getAll() {
        return dataList;
    }

    @Override
    public void addData(MedicalRecord data) {
        dataList.add(data);
    }

    @Override
    public void updateData(MedicalRecord oldData, MedicalRecord newData) {
        int index = dataList.indexOf(oldData);
        if (index >= 0) {
            dataList.set(index, newData);
        }
    }

    @Override
    public void deleteData(MedicalRecord data) {
        dataList.remove(data);
    }
}