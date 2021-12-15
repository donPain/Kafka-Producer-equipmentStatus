package com.kafka.producer.demo.producers;

import com.kafka.producer.demo.model.EquipmentStatus;
import com.kafka.producer.demo.model.Kijo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class KijoProducer {

    @Autowired
    private KafkaTemplate<String, Kijo> kijoProducerTemplate;

    @Autowired
    private KafkaTemplate<String, EquipmentStatus> EquipmentStatusProducerTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void sendStatus(){

        for(int i=0;i<1000000;i++){

            String[] owners = {"AMAGGI", "GROWMARK", "RAIZEN","CASA_DO_PAO_DE_ALHO","PEIXARIA_DO_CURU","BILDBULKR"};
            String[] equipments = {"EQUIPAMENTO_01","EQUIPAMENTO_02","EQUIPAMENTO_06", "EQUIPAMENTO_07", "EQUIPAMENTO_15", "EQUIPAMENTO_44","EQUIPAMENTO_09","EQUIPAMENTO_10","EQUIPAMENTO_11","EQUIPAMENTO_12" };
            String[] Status = {"ONLINE","OFFLINE"};
            String clientId = getRandomElement(owners);
            String equipmentStatusOnline = getRandomElement(Status);
            String equipmentId = getRandomElement(equipments);
            String Key = clientId + "_" + equipmentId;
            kijoProducerTemplate.send("SRC_KIJO", Key, new Kijo(clientId,equipmentId,"KIJO2300|AXT,"+UUID.randomUUID().toString()+",125421"));
            EquipmentStatusProducerTemplate.send("EQUIPMENT_STATUS", Key, new EquipmentStatus(clientId,equipmentId,equipmentStatusOnline,LocalDate.now().toString()));
            System.out.println("Enviando Kijo e Status do equipamento.");
        }
    }

    public static <T> T getRandomElement(T[] arr){
        return arr[ThreadLocalRandom.current().nextInt(arr.length)];
    }

}
