package com.kafka.producer.demo.model;

public class Kijo {

    private String kijoClientId;
    private String kijoEquipmentId;
    private String kijoString;

    public Kijo(String kijoClientId, String kijoEquipmentId, String kijoString){
        this.kijoClientId  = kijoClientId;
        this.kijoEquipmentId = kijoEquipmentId;
        this.kijoString = kijoString;
    };

    public String getKijoClientId() {
        return kijoClientId;
    }

    public void setKijoClientId(String kijoClientId) {
        this.kijoClientId = kijoClientId;
    }

    public String getKijoEquipmentId() {
        return kijoEquipmentId;
    }

    public void setKijoEquipmentId(String kijoEquipmentId) {
        this.kijoEquipmentId = kijoEquipmentId;
    }

    public String getKijoString() {
        return kijoString;
    }

    public void setKijoString(String kijoString) {
        this.kijoString = kijoString;
    }

}
