package com.kafka.producer.demo.model;

public class EquipamentStatus {


    public EquipamentStatus(String clientId, String equipamentId, String equipamentStatus, String since){
        this.clientId = clientId;
        this.equipamentId = equipamentId;
        this.equipamentStatus = equipamentStatus;
        this.since = since;
    };




    public String getClientId() {
        return clientId;
    }

    public String toJson() {
        return "EquipamentJson{" +
                "clientId:" + clientId +
                ", equipamentId:" + equipamentId +
                ", equipamentStatus:" + equipamentStatus +
                ", since:" + since +
                '}';
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String clientId;
    private String equipamentId;
    private String equipamentStatus;
    private String since;


    public String getEquipamentId() {
        return equipamentId;
    }

    public void setEquipamentId(String equipamentId) {
        this.equipamentId = equipamentId;
    }

    public String getEquipamentStatus() {
        return equipamentStatus;
    }

    public void setEquipamentStatus(String equipamentStatus) {
        this.equipamentStatus = equipamentStatus;
    }

    public String getsince() {
        return since;
    }

    public void setsince(String since) {
        this.since = since;
    }


}