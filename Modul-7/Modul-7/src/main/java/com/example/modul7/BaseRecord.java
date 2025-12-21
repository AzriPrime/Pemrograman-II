package com.example.modul7;

public abstract class BaseRecord {
    protected String id;

    public BaseRecord(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getInfoRingkas();
}