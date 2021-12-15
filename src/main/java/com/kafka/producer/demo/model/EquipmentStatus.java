package com.kafka.producer.demo.model;

public class EquipmentStatus {



    private String clientId;
    private String equipmentId;
    private String equipmentStatus;
    private String since;

    public EquipmentStatus(String clientId, String equipmentId, String equipmentStatus, String since) {
        this.clientId = clientId;
        this.equipmentId = equipmentId;
        this.equipmentStatus = equipmentStatus;
        this.since = since;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }



    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getsince() {
        return since;
    }

    public void setsince(String since) {
        this.since = since;
    }


}