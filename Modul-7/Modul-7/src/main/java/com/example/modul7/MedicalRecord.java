package com.example.modul7;

public class MedicalRecord extends BaseRecord {
    private String namaPasien;
    private String keluhan;
    private String diagnosa;
    private String tindakan;
    private String tanggal;

    public MedicalRecord(String id, String namaPasien, String keluhan, String diagnosa, String tindakan, String tanggal) {
        super(id);
        this.namaPasien = namaPasien;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.tindakan = tindakan;
        this.tanggal = tanggal;
    }

    @Override
    public String getInfoRingkas() {
        return "Pasien " + namaPasien + " didiagnosa " + diagnosa;
    }

    //GETSET
    public String getNamaPasien() { return namaPasien; }
    public void setNamaPasien(String namaPasien) { this.namaPasien = namaPasien; }

    public String getKeluhan() { return keluhan; }
    public void setKeluhan(String keluhan) { this.keluhan = keluhan; }

    public String getDiagnosa() { return diagnosa; }
    public void setDiagnosa(String diagnosa) { this.diagnosa = diagnosa; }

    public String getTindakan() { return tindakan; }
    public void setTindakan(String tindakan) { this.tindakan = tindakan; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
}