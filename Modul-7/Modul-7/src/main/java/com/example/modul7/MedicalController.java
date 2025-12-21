package com.example.modul7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicalController implements Initializable {

    @FXML private TextField txtId, txtNama, txtKeluhan, txtDiagnosa, txtTindakan, txtTanggal;
    @FXML private TableView<MedicalRecord> tableMedis;
    @FXML private TableColumn<MedicalRecord, String> colId, colNama, colKeluhan, colDiagnosa, colTindakan, colTanggal;
    @FXML private Label lblStatus;

    private MedicalService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new InMemoryRepository();

        //Penghubung class ke kolom tabel
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("namaPasien"));
        colKeluhan.setCellValueFactory(new PropertyValueFactory<>("keluhan"));
        colDiagnosa.setCellValueFactory(new PropertyValueFactory<>("diagnosa"));
        colTindakan.setCellValueFactory(new PropertyValueFactory<>("tindakan"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        // Load Data Awal
        tableMedis.setItems(service.getAll());

        // Listener saat baris tabel diklik
        tableMedis.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateForm(newSelection);
                lblStatus.setText(newSelection.getInfoRingkas());
            }
        });
    }

    @FXML
    private void handleSave() {
        MedicalRecord record = new MedicalRecord(
                txtId.getText(), txtNama.getText(), txtKeluhan.getText(),
                txtDiagnosa.getText(), txtTindakan.getText(), txtTanggal.getText()
        );
        service.addData(record);
        handleClear();
    }

    @FXML
    private void handleUpdate() {
        MedicalRecord selected = tableMedis.getSelectionModel().getSelectedItem();
        if (selected != null) {
            MedicalRecord newRecord = new MedicalRecord(
                    txtId.getText(), txtNama.getText(), txtKeluhan.getText(),
                    txtDiagnosa.getText(), txtTindakan.getText(), txtTanggal.getText()
            );
            service.updateData(selected, newRecord);
            handleClear();
            tableMedis.refresh(); // Refresh tampilan tabel
        }
    }

    @FXML
    private void handleDelete() {
        MedicalRecord selected = tableMedis.getSelectionModel().getSelectedItem();
        if (selected != null) {
            service.deleteData(selected);
            handleClear();
        }
    }

    @FXML
    private void handleClear() {
        txtId.clear();
        txtNama.clear();
        txtKeluhan.clear();
        txtDiagnosa.clear();
        txtTindakan.clear();
        txtTanggal.clear();
        tableMedis.getSelectionModel().clearSelection();
        lblStatus.setText("Siap.");
    }

    private void populateForm(MedicalRecord record) {
        txtId.setText(record.getId());
        txtNama.setText(record.getNamaPasien());
        txtKeluhan.setText(record.getKeluhan());
        txtDiagnosa.setText(record.getDiagnosa());
        txtTindakan.setText(record.getTindakan());
        txtTanggal.setText(record.getTanggal());
    }
}